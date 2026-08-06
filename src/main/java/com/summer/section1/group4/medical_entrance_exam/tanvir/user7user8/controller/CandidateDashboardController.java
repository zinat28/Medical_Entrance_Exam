package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;

import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.CandidateDAO;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.Candidate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class CandidateDashboardController {

    @FXML
    private TableView<Candidate> candidateTable;

    @FXML
    private TableColumn<Candidate, Integer> idColumn;

    @FXML
    private TableColumn<Candidate, String> nameColumn;

    @FXML
    private TableColumn<Candidate, String> rollColumn;

    @FXML
    private TableColumn<Candidate, Double> gpaColumn;

    @FXML
    private TableColumn<Candidate, String> statusColumn;

    private final CandidateDAO candidateDAO = new CandidateDAO();

    @FXML
    public void initialize() {

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );

        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );

        rollColumn.setCellValueFactory(
                new PropertyValueFactory<>("roll")
        );

        gpaColumn.setCellValueFactory(
                new PropertyValueFactory<>("gpa")
        );

        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );

        loadCandidates();
    }

    private void loadCandidates() {

        ObservableList<Candidate> candidates =
                FXCollections.observableArrayList(
                        candidateDAO.getAllCandidates()
                );

        candidateTable.setItems(candidates);
    }

    @FXML
    private void refreshCandidates() {
        loadCandidates();
    }

    @FXML
    private void handleAddCandidate() {

        try {

            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource(
                            "/com/summer/section1/group4/medical_entrance_exam/tanvir/add_candidate.fxml"
                    )
            );

            Parent root = loader.load();

            Stage addStage = new Stage();

            addStage.setTitle("Add Candidate");
            addStage.setScene(new Scene(root));
            addStage.initModality(Modality.APPLICATION_MODAL);

            addStage.showAndWait();

            loadCandidates();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}