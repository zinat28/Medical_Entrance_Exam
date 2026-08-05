package com.summer.section1.group4.medical_entrance_exam;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("login.fxml")
        );

        Scene scene = new Scene(fxmlLoader.load());

        stage.setTitle("Combined Medical Entrance Exam Portal");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}
