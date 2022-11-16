package com.example.hopeitworks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Label welcomeText;
    @FXML
    private Label gettext;
    @FXML
    private Label byetext;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    protected void onGetButtonClick() {
        gettext.setText("Get Lost!");
    }
    @FXML
    protected void onLeaveButtonClick(){
        byetext.setText("Bye Bye!");
    }
    @FXML
    public void onchangeSceneButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("bed_2.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onchangeScene2ButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("bed_3.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onBedInfoButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
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
    public void onRevenueButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("Revenue_gen.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onRevenue2ButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("Revenue_gen2.fxml"));
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
    public void onBackButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }

    @FXML
    public void onEnrollNewButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("Patientenroll.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onEnrollButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("patient_infos.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onCancelButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("patients_info.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onGoBackButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("patients_info.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onSignUpButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("Signup.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onSignUp2ButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }
    @FXML
    public void onSignInButtonClick(ActionEvent event) throws IOException{
        Parent NextParent = FXMLLoader.load(getClass().getResource("loginform.fxml"));
        Scene NextScene = new Scene(NextParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(NextScene);
        window.show();
    }

}
