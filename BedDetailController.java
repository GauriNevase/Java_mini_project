
package com.example.hopeitworks;


import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BedDetailController implements Initializable {
    @FXML
    private TableView<bedinfomodel> bedTableView;
    @FXML
    private TableColumn<bedinfomodel, Integer> patientIdTableColumn;
    @FXML
    private TableColumn<bedinfomodel, String> patientNameTableColumn;
    @FXML
    private TableColumn<bedinfomodel, Integer> bedIdTableColumn;
    @FXML
    private TableColumn<bedinfomodel, Integer> bedOccupancyTableColumn;
    @FXML
    private TableColumn<bedinfomodel, Integer> AgeTableColumn;
    @FXML
            public Label roomid;
    ObservableList<bedinfomodel> listN;
    ObservableList<bedinfomodel> listN2;

    public void initialize(URL url, ResourceBundle rb) {
    //setTable();
    }
    public void general(ActionEvent event) throws IOException, SQLException {

        setTable();

//        Parent root = FXMLLoader.load((getClass().getResource("bed_table.fxml")));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
        roomid.setText("1");
    }
    public void emergency(ActionEvent event) throws IOException{
        roomid.setText("2");
        setTable2();
//        Parent root = FXMLLoader.load((getClass().getResource("bed_table.fxml")));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

    }
    public void ICU(ActionEvent event) throws IOException{
        roomid.setText("3");
        setTable3();
//        Parent root = FXMLLoader.load((getClass().getResource("bed_table.fxml")));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

    }
    public void privatea(ActionEvent event) throws IOException{
        roomid.setText("4");
        setTable4();
//        Parent root = FXMLLoader.load((getClass().getResource("bed_table.fxml")));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

    }
    public void privateb(ActionEvent event) throws IOException{
        roomid.setText("5");
        setTable5();
//        Parent root = FXMLLoader.load((getClass().getResource("bed_table.fxml")));
//        Stage stage = new Stage();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();

    }
    public void back(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("dashboard.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void setTable() {
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientId"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientName"));
        bedIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("BedId"));
        bedOccupancyTableColumn.setCellValueFactory(new PropertyValueFactory<>("BedOccupancy"));
        AgeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));

        listN = DatabaseConnection.getInfo();
        bedTableView.setItems(listN);
    }
    public void setTable2() {
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientId"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientName"));
        bedIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("BedId"));
        bedOccupancyTableColumn.setCellValueFactory(new PropertyValueFactory<>("BedOccupancy"));
        AgeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));

        listN2 = DatabaseConnection.getInfo2();
        bedTableView.setItems(listN2);
    }
    public void setTable3() {
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientId"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientName"));
        bedIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("BedId"));
        bedOccupancyTableColumn.setCellValueFactory(new PropertyValueFactory<>("BedOccupancy"));
        AgeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));

        listN2 = DatabaseConnection.getInfo3();
        bedTableView.setItems(listN2);
    }
    public void setTable4() {
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientId"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientName"));
        bedIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("BedId"));
        bedOccupancyTableColumn.setCellValueFactory(new PropertyValueFactory<>("BedOccupancy"));
        AgeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));

        listN2 = DatabaseConnection.getInfo4();
        bedTableView.setItems(listN2);
    }
    public void setTable5() {
        patientIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientId"));
        patientNameTableColumn.setCellValueFactory(new PropertyValueFactory<>("PatientName"));
        bedIdTableColumn.setCellValueFactory(new PropertyValueFactory<>("BedId"));
        bedOccupancyTableColumn.setCellValueFactory(new PropertyValueFactory<>("BedOccupancy"));
        AgeTableColumn.setCellValueFactory(new PropertyValueFactory<>("Age"));

        listN2 = DatabaseConnection.getInfo5();
        bedTableView.setItems(listN2);
    }


}


