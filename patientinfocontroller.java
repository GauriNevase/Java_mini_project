package com.example.hopeitworks;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class patientinfocontroller implements Initializable {


    @FXML
    private TableView<patientinfomodel> patientTableView;

    @FXML
    private TableColumn<patientinfomodel, Integer> patientIdTableColumn;
    @FXML
    private TableColumn<patientinfomodel, String> patientNameTableColumn;
    @FXML
    private TableColumn<patientinfomodel, String> wardname;
    @FXML
    private TableColumn<patientinfomodel, String> roomAssignedTableColumn;
    @FXML
    private TableColumn<patientinfomodel, String> addmissionDateTableColumn;
    @FXML
    public TextField delete;
    @FXML
            public Label Alertbox;

    ObservableList<patientinfomodel> listM;

    public void initialize(URL url, ResourceBundle rb) {
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientId"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientName"));
        wardname.setCellValueFactory(new PropertyValueFactory<>("Wardname"));
        roomAssignedTableColumn.setCellValueFactory(new PropertyValueFactory<>("RoomAssigned"));
        addmissionDateTableColumn.setCellValueFactory(new PropertyValueFactory<>("AddmissionDate"));
        // DatabaseConnection connectNow = new DatabaseConnection();
        //Connection connectDB = connectNow.connectDb();

        listM = DatabaseConnection.getData();
        patientTableView.setItems(listM);

    }



    @FXML
    public void onEnrollNewButtonClick(ActionEvent event) throws IOException {
        Parent NextParent = FXMLLoader.load(getClass().getResource("Patientenroll.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onDashboardButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onPatientInfoButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("patients_info.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onBedInfoButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("bed_ui.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    public void Logout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("loginform.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

//    @FXML
//    public void onDELETE(ActionEvent event) throws IOException{
//        String query = "UPDATE `hbms_new`.`patient` SET 'p_allotment_status' = 0 where `p_id` ";
////        Parent NextParent = FXMLLoader.load(getClass().getResource("patients_info.fxml"));
////        Scene NextScene = new Scene(NextParent);
////        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
////        window.setScene(NextScene);
////        window.show();
//    }
    @FXML
    public void onDelete(ActionEvent event) {

            String id = delete.getText();
            if(id.equals("")) {
                Alertbox.setText("Patient ID Field is Empty!");
                //System.out.println("id Field is empty!");
            } else {
                try {

                    DatabaseConnection.delete(Integer.valueOf(id));

                    //listM = DatabaseConnection.getData(id);
                    //doctorTable.setItems(listM);
                    Alertbox.setText("Patient Deleted Successfully!");
                } catch (SQLException ex) {
                    Alertbox.setText("Patient Deleted Successfully");
                    //System.out.println(ex);
                }
            }

    }
}
