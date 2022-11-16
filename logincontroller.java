package com.example.hopeitworks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.sql.DriverManager;



import java.io.IOException;
import java.sql.*;


public class logincontroller {


    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label invalidlogin;
    @FXML
    private Button b_Signin;

    @FXML
    public Label AlertBox;

    @FXML
    public PasswordField conpassfield;

    @FXML
    public TextField usernameTextField1;
    @FXML
    public TextField usernameTextField2;
    @FXML
    public TextField usernameTextField3;

    @FXML
    private Label user;
    @FXML
    public PasswordField passField;

    @FXML
    private Stage stage;
    private Scene scene;
    String username;
    public void Signin(ActionEvent event) {
        String Sql = "SELECT * FROM user WHERE user_name = ? AND user_password = ?";

        Connection connect = DatabaseConnection.connectDb();

        try {
            PreparedStatement prepare = connect.prepareStatement(Sql);
            prepare.setString(1, usernameTextField.getText());
            prepare.setString(2, passwordField.getText());

            ResultSet result = prepare.executeQuery();

            if (usernameTextField.getText().isEmpty() || passwordField.getText().isEmpty()) {

                AlertBox.setText("Please fill all the details");


            } else if (result.next()) {
                username=usernameTextField.getText();
                Parent NextParent = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                Scene NextScene = new Scene(NextParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(NextScene);
                window.show();

                AlertBox.setText("Successfully login");

            } else {

                AlertBox.setText("Wrong Username or Password");
            }


        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }


    }

    @FXML
    public void onSignUpButtonClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load((getClass().getResource("Signup.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void Signup2(ActionEvent event){

        try {
            Connection connect = DatabaseConnection.connectDb();
            //Creating Connection Object
            String Sql = "INSERT INTO `hbms_db`.`user`(user_name,user_firstname,user_lastname,user_password) VALUES(?,?,?,?)";

            //Preapared Statement
            PreparedStatement Pstatement=connect.prepareStatement(Sql);
            //Specifying the values of it's parameter

            Pstatement.setString(1,usernameTextField1.getText());
            Pstatement.setString(2,usernameTextField2.getText());
            Pstatement.setString(3,usernameTextField3.getText());
            Pstatement.setString(4,passField.getText());
            //Pstatement.setString(5,conpassfield.getText());
            int result = Pstatement.executeUpdate();
            Alert alert;

            //Checking for the Password match
            if(usernameTextField1.getText().isEmpty()||passField.getText().isEmpty()) {

                AlertBox.setText("Please fill all the details");


            }

            else if(passField.getText().equalsIgnoreCase(conpassfield.getText()))
            {
                //int result2 = Pstatement.executeUpdate();
                //Executing query
                Parent NextParent = FXMLLoader.load(getClass().getResource("loginform.fxml"));
                Scene NextScene = new Scene(NextParent);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(NextScene);
                window.show();
                AlertBox.setText("Data Registered Successfully");
            } else
            {
                AlertBox.setText("Password did not match");
            }

        } catch (SQLException | IOException e1) {
            e1.printStackTrace();
        }



    }
    public void SignIn1(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("loginform.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void Logout(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("loginform.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    public void Dashboard(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("dashboard.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }public void Patientinfo(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("patients_info.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }public void bedinfo(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load((getClass().getResource("hello-view.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public abstract class DashboardController implements Initializable {
        @FXML
        private Label AdmitsNumber;

        @FXML
        private void Admittedvalue() throws SQLException {//label changes= calculates the number of patients from the database

            DatabaseConnection connectnow = new DatabaseConnection();
            Connection connectdb = connectnow.connectDb();
            String query = "select count(*) from patient where p_allotment_status=1;";

            PreparedStatement pnew = null;
            int count = pnew.executeUpdate(query);
            ResultSet rs = pnew.executeQuery(query);
            AdmitsNumber.setText(String.valueOf(count));
        }
        public void setAdmitNumber() throws SQLException {
            DatabaseConnection databaseConnection = new DatabaseConnection();
            Connection connectdb = databaseConnection.connectDb();
            Statement st = null;
            st = connectdb.createStatement();
            String query = "select count(*) from patient where p_allotment_status=1;";
            ResultSet rs = null;
            rs = st.executeQuery(query);
            rs.next();
            //displays number of rows returned after query execution
            AdmitsNumber.setText(String.valueOf(rs.getInt("count(*)")));


        }
    }

}