package com.summer.section1.group4.medical_entrance_exam.zinat;

import com.summer.section1.group4.medical_entrance_exam.HelloApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class SceneSwitcher {
    private static Stage mainStage;

    public static void setStage(Stage stage) {
        mainStage = stage;
    }

    public static void switchTo(String fxmlPath) throws IOException {
        FXMLLoader loader = new FXMLLoader(SceneSwitcher.class.getResource(fxmlPath));
        Scene scene = new Scene(loader.load());
        mainStage.setScene(scene);   // this is line 15 failing — mainStage is null
    }
}