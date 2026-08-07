module com.summer.section1.group4.medical_entrance_exam {

        requires javafx.controls;
        requires javafx.fxml;
        requires java.sql;

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

        opens com.summer.section1.group4.medical_entrance_exam.JubayerAhmed_2330814 to javafx.fxml;

        exports com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;
        exports com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model;
        exports com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao;
        exports com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;
        }