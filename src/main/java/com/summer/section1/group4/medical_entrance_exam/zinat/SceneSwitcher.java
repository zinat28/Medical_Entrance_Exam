package com.summer.section1.group4.medical_entrance_exam.zinat;

import com.summer.section1.group4.medical_entrance_exam.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneSwitcher {
    public static Stage stage;

    public static void switchTo(String fxmlFileName) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource(fxmlFileName));
        Scene scene = new Scene(loader.load());
        stage.setScene(scene);
    }

}