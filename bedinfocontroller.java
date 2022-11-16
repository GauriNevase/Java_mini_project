package com.example.hopeitworks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class bedinfocontroller {
    @FXML
    public void emergency(ActionEvent event) throws IOException {
        Parent NextParent = FXMLLoader.load(getClass().getResource("bed_table.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void general(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("bed_table.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void ICU(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("bed_table.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void privateA(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("bed_table.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void privateB(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("bed_table.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
}
