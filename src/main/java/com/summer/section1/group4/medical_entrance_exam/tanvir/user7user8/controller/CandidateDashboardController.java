package com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.controller;


import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.dao.CandidateDAO;
import com.summer.section1.group4.medical_entrance_exam.tanvir.user7user8.model.Candidate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class CandidateDashboardController {


    @FXML
    private TableView<Candidate> candidateTable;


    @FXML
    private TableColumn<Candidate,Integer> idColumn;


    @FXML
    private TableColumn<Candidate,String> nameColumn;


    @FXML
    private TableColumn<Candidate,String> emailColumn;


    @FXML
    private TableColumn<Candidate,String> phoneColumn;


    @FXML
    private TableColumn<Candidate,String> statusColumn;



    private CandidateDAO candidateDAO = new CandidateDAO();



    @FXML
    public void initialize(){

        idColumn.setCellValueFactory(
                new PropertyValueFactory<>("id")
        );


        nameColumn.setCellValueFactory(
                new PropertyValueFactory<>("name")
        );


        emailColumn.setCellValueFactory(
                new PropertyValueFactory<>("email")
        );


        phoneColumn.setCellValueFactory(
                new PropertyValueFactory<>("phone")
        );


        statusColumn.setCellValueFactory(
                new PropertyValueFactory<>("status")
        );


        loadCandidates();

    }



    private void loadCandidates(){

        ObservableList<Candidate> list =
                FXCollections.observableArrayList(
                        candidateDAO.getAllCandidates()
                );


        candidateTable.setItems(list);

    }



    @FXML
    public void refreshCandidates(){

        loadCandidates();

    }


}