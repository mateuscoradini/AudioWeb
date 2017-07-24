package com.privates.audio.fx;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
@Import(ScreensConfiguration.class)
@ImportResource("classpath:/WEB-INF/spring/security.xml")
public class UserAppConfiguration {

	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setMessageConverters(
				Collections.<HttpMessageConverter<?>> singletonList(new MappingJackson2HttpMessageConverter()));
		return restTemplate;
	}

}
