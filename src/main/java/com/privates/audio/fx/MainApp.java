package com.privates.audio.fx;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class MainApp extends Application {
	
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
    	WebView web = new WebView();  
        web.getEngine().load("http://localhost:8080/");  
        
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();

        //set Stage boundaries to visible bounds of the main screen
        stage.setX(primaryScreenBounds.getMinX());
        stage.setY(primaryScreenBounds.getMinY());
        stage.setWidth(primaryScreenBounds.getWidth());
        stage.setHeight(primaryScreenBounds.getHeight());
        
        Scene scene = new Scene(web);  
        stage.setScene(scene);  
        stage.show();  
    }

}
