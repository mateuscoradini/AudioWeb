package com.privates.audio.fx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

@Component
public class LoginFXController implements DialogController {

	@Autowired
	private AuthenticationManager authenticationManager;
	private ScreensConfiguration screens;
	private FXMLDialog dialog;

	public void setDialog(FXMLDialog dialog) {
		this.dialog = dialog;
	}

	public LoginFXController(ScreensConfiguration screens) {
		this.screens = screens;
	}

	@FXML
	Label header;
	@FXML
	TextField username;
	@FXML
	TextField password;

	@FXML
	public void login() {
		Authentication authToken = new UsernamePasswordAuthenticationToken(username.getText(), password.getText());
		try {
			authToken = authenticationManager.authenticate(authToken);
			SecurityContextHolder.getContext().setAuthentication(authToken);
		} catch (AuthenticationException e) {
			header.setText("Login failure, please try again:");
			header.setTextFill(Color.DARKRED);
			return;
		}
		dialog.close();
		screens.showScreen(screens.customerDataScreen());
	}

	@FXML
	private void closeButtonAction() {
		dialog.close();
		System.exit(0);
	}

	@FXML
	public void user() {
		username.setText("user");
		password.setText("user");
	}

	@FXML
	public void admin() {
		username.setText("admin");
		password.setText("admin");
	}
}
