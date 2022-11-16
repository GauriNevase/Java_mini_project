/*package com.example.hopeitworks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class signupcontroller {
    @FXML
    public Label usernamelabel;

    @FXML
    public Label passwordlabel;

    @FXML
    public TextField usernameTextField;

    @FXML
    public PasswordField passwordField;

    @FXML
    public PasswordField conpassfield;

    @FXML
    public Label Alertbox;

    @FXML
    public Button Signup2;

    @FXML
    public Button Signin1;

    public void Signup2(ActionEvent event){
        String Sql ="SELECT * FROM user WHERE user_name = ? AND user_password = ?";

        Connection connect = DatabaseConnection.connectDb();

        try{
            PreparedStatement prepare = connect.prepareStatement(Sql);
            prepare.setString(1, usernameTextField.getText());
            prepare.setString(2, passwordField.getText());

            ResultSet result = prepare.executeQuery();
            Alert alert;

            if(usernameTextField.getText().isEmpty()||passwordField.getText().isEmpty()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error message");
                alert.setHeaderText("null");
                Alertbox.setText("Please fill all the details");
                alert.setContentText("please fill all the details");

            }else if (result.next()) {
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("INFORMATION MESSAGE");
                alert.setHeaderText("null");
                Alertbox.setText("Successfully login");
                Signup2.getScene().getWindow().hide();
                Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                Stage stage = new Stage();
                Scene scene = new Scene(root);

                stage.setScene(scene);
                stage.show();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("error message");
                alert.setHeaderText("null");
                alert.setContentText("Wrong username/password");
            }



        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }



    }
    public void SignIn1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("loginform.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}

 */
