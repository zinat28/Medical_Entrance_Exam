module com.summer.section1.group4.medical_entrance_exam {

        requires javafx.controls;
        requires javafx.fxml;
        requires java.sql;
    requires javafx.graphics;

    opens com.summer.section1.group4.medical_entrance_exam
        to javafx.graphics, javafx.fxml;

        opens com.summer.section1.group4.medical_entrance_exam.zinat
        to javafx.fxml;

        opens com.summer.section1.group4.medical_entrance_exam.zinat.Applicant
        to javafx.fxml;

        opens com.summer.section1.group4.medical_entrance_exam.zinat.QuestionModerator
        to javafx.fxml;

        opens com.summer.section1.group4.medical_entrance_exam.tanvir
        to javafx.fxml;

        opens com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller
        to javafx.fxml;

        opens com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model
        to javafx.base, javafx.fxml;
        exports com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;
        exports com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model;
        exports com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao;
        exports com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;

        opens com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814 to javafx.fxml;
        opens com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.Controller to javafx.fxml;

        opens com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.NonUser to javafx.fxml;
        opens com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814.User to javafx.fxml;

        opens com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223 to javafx.fxml;
        opens com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.Controller to javafx.fxml;

        opens com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.NonUser to javafx.fxml;
        opens com.summer.section1.group4.medical_entrance_exam.JakiaJumana_1920223.User to javafx.fxml;


        }