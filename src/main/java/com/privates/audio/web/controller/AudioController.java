package com.privates.audio.web.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.privates.audio.web.entity.Audio;
import com.privates.audio.web.entity.AudioStream;
import com.privates.audio.web.entity.Project;
import com.privates.audio.web.entity.ProjectAudio;
import com.privates.audio.web.entity.Track;
import com.privates.audio.web.service.AudioService;
import com.privates.audio.web.service.ProjectService;

@Controller
public class AudioController {

	public static final String REDIRECT_URL = "redirect:/";

	@Autowired
	private ProjectService projectService;

	@Autowired
	private AudioService audioService;

	@ResponseBody
	@RequestMapping(value = "/users/getAllAudios", method = RequestMethod.POST)
	public List<Audio> getAllAudios(@RequestBody String search) {
		System.out.println("method test()");
		return null;
		// return audioRepository.findAll();
	}

	@ResponseBody
	@RequestMapping(value = "/users/getAudioStream/{id}", method = RequestMethod.GET)
	public byte[] getAudioStream(HttpServletRequest request, HttpServletResponse response, @PathVariable long id) {
		String idStr = request.getParameter("id");
		Audio audio = new Audio();
		audio.setId(id);
		AudioStream audioStream = new AudioStream();// audioStreamRepository.findByAudio(audio);
		response.setContentType("audio/mpeg");
		response.setStatus(response.SC_PARTIAL_CONTENT);// SC_PARTIAL_CONTENT
		response.setContentLength(audioStream.getAudio_stream().length);
		return audioStream.getAudio_stream();
	}

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public @ResponseBody String provideUploadInfo() {
		return "You can upload a file by posting to this same URL.";
	}

	@RequestMapping(value = "/projects/audio/upload", method = RequestMethod.POST)
	public String handleFileUpload(@RequestParam("file") MultipartFile file,
			@RequestParam("projectName") String projectName) {

		if (projectName != null && !"".equals(projectName)) {

			if (!file.isEmpty()) {
				try {
					String name = file.getName();
					byte[] bytes = file.getBytes();
					BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(name)));
					stream.write(bytes);

					Project project = projectService.findByName(projectName);

					Audio audio = new Audio();
					audio.setEnabled(true);
					audio.setFileName(file.getOriginalFilename());
					AudioStream audioStream = new AudioStream();
					audioStream.setAudio(audio);
					audioStream.setAudio_stream(bytes);
					audio.setAudioStream(audioStream);

					audio = audioService.save(audio);

					ProjectAudio projectAudio = new ProjectAudio();
					projectAudio.setAudio(audio);
					projectAudio.setProject(project);
					projectAudio = audioService.saveProjectAudio(projectAudio);

					stream.close();
					return REDIRECT_URL + "projects/projectsDetails.html?success=true";
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else {
				System.out.println("empty");
			}

		}
		return REDIRECT_URL + "projects/projectsDetails.html?success=true";

	}

	@ResponseBody
	@RequestMapping(value = "/audioUser/findAllProjectAudios", method = RequestMethod.POST)
	public List<Project> getSearchResultViaAjax(@RequestBody String search) {
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		Map<Project, List<Audio>> map = audioService.getAllProjectAudios(userDetails);
		List<Project> projects = new ArrayList<Project>();
		for (Entry<Project, List<Audio>> entry : map.entrySet()) {
			
			Project project = entry.getKey();
			project.setListAudio(entry.getValue());
			
			projects.add(project);
		}
		return projects;

	}
	
	@ResponseBody
	@RequestMapping(value = "/audioUser/findUserPrivateAudios", method = RequestMethod.POST)
	public List<Track> getAllUserPrivateAudios(@RequestBody String search) {

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		List<Audio> listAudio = audioService.findAudioAndStreamByUser(userDetails);
		int i = 0;
		List<Track> tracks = new ArrayList<Track>();
		for (Audio audio : listAudio) {

			i++;
			Track track = new Track();

			// int d = audioFile.getAudioHeader().getTrackLength();
			track.setTrack(i);
			track.setAudioId(audio.getId());
			track.setLength(audio.getAudioStream().getAudio_stream().length);
			track.setName(audio.getFileName());
			track.setFile(audio.getAudioStream().getAudio_stream());
			track.setProjectName(audio.getProject().getName());
			tracks.add(track);

		}

		return tracks;

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/audioUser/requestPermission", method = RequestMethod.POST)
	public String requestPermission(@RequestBody final String audioID) {
		String response = "true";		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		audioService.addAudioPermissionRequest(userDetails, Long.parseLong(audioID.replace("\"", "")));
		return response;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/users/audioUser/acceptByAjax", method = RequestMethod.POST)
	public String accept(@RequestBody final String audioRoleId) {
		String response = "true";
		
		audioService.createUserAudio(Long.parseLong(audioRoleId.replace("\"", "")));
		return response;
	}
	
	
	@RequestMapping(value = "/recfile/{id}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_OCTET_STREAM_VALUE })
	public HttpEntity<byte[]> downloadRecipientFile(@PathVariable("id") long id, ModelMap model,
			HttpServletResponse response) throws IOException, ServletException {
		Audio audio = audioService.findById(id);
		
		HttpHeaders header = new HttpHeaders();
		// header.setContentType(new MediaType("audio", "mp3"));
		header.setContentType(new MediaType("audio", "mpeg"));
		header.setContentDispositionFormData("filename", audio.getFileName());
		header.setContentLength(audio.getAudioStream().getAudio_stream().length);
		
		return new HttpEntity<byte[]>(audio.getAudioStream().getAudio_stream(), header);
	}
	
	
	

}
