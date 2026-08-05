module com.summer.section1.group4.medical_entrance_exam {

    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.xerial.sqlitejdbc;

    // JavaFX must access your Application class
    exports com.summer.section1.group4.medical_entrance_exam.tanvir
            to javafx.graphics;

    // FXML must access the controllers
    opens com.summer.section1.group4.medical_entrance_exam.tanvir
            to javafx.fxml;

    opens com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller
            to javafx.fxml;

    // Export model/database packages when used by other classes
    exports com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model;
    exports com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao;
    exports com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.database;
}