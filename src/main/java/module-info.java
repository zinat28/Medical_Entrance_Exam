module com.summer.section1.group4.medical_entrance_exam {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    exports com.summer.section1.group4.medical_entrance_exam.tanvir
            to javafx.graphics;

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
}