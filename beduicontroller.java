package com.example.hopeitworks;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class beduicontroller {
    public void general(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("bed_table.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void emergency(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("bed_table.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void ICU(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("bed_table.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void privatea(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("bed_table.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void privateb(ActionEvent event) throws IOException{


        Parent root = FXMLLoader.load((getClass().getResource("bed_table.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void back(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("dashboard.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
