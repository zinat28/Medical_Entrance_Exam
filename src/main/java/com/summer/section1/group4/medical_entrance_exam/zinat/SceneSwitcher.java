package com.summer.section1.group4.medical_entrance_exam.zinat;

import com.summer.section1.group4.medical_entrance_exam.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitcher {
    public static Stage stage;
    public static void switchTo(String fxml) {
        try {
            Parent root = FXMLLoader.load(HelloApplication.class.getResource(fxml));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
