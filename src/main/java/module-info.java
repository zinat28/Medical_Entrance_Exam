module com.summer.section1.group4.medical_entrance_exam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.summer.section1.group4.medical_entrance_exam to javafx.fxml;
    exports com.summer.section1.group4.medical_entrance_exam;
}