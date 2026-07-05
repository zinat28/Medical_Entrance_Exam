package com.summer.section1.group4.medical_entrance_exam;

import com.summer.section1.group4.medical_entrance_exam.zinat.SceneSwitcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        SceneSwitcher.stage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/summer/section1/group4/medical_entrance_exam/zinat/Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }
}
