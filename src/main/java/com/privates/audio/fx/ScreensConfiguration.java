package com.privates.audio.fx;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

@Configuration
@Component
@Lazy
public class ScreensConfiguration {
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public void showScreen(Parent screen) {
        primaryStage.setScene(new Scene(screen, 777, 500));
        primaryStage.show();
    }

    @Bean
    UserDataScreen customerDataScreen() {
        return new UserDataScreen(customerDataScreenController());
    }

    @Bean
    UserDataScreenController customerDataScreenController() {
        return new UserDataScreenController(this);
    }

    @Bean
    @Scope("prototype")
    FXMLDialog errorDialog() {
        return new FXMLDialog(errorController(), getClass().getResource("Error.fxml"), primaryStage, StageStyle.UNDECORATED);
    }

    @Bean
    @Scope("prototype")
    ErrorController errorController() {
        return new ErrorController();
    }

//    @Bean
//    @Scope("prototype")
//    FXMLDialog addCustomerDialog() {
//        return new FXMLDialog(addCustomerController(), getClass().getResource("AddCustomer.fxml"), primaryStage);
//    }

//    @Bean
//    @Scope("prototype")
//    AddCustomerController addCustomerController() {
//        return new AddCustomerController();
//    }

    @Bean
    @Scope("prototype")
    FXMLDialog loginDialog() {
        return new FXMLDialog(loginController(), getClass().getResource("Login.fxml"), primaryStage, StageStyle.UNDECORATED);
    }

    @Bean
    @Scope("prototype")
    LoginFXController loginController() {
        return new LoginFXController(this);
    }
    
}
