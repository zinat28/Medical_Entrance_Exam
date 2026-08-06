package com.summer.section1.group4.medical_entrance_exam.tanvir;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource(
                        "/com/summer/section1/group4/medical_entrance_exam/tanvir/login.fxml"
                )
        );

        Scene scene = new Scene(fxmlLoader.load(), 600, 450);

        stage.setTitle("Combined Medical Entrance Exam Portal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}