package com.example.hopeitworks;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;



public class Dashboardcontroller extends logincontroller implements Initializable {
    @FXML
    public StackedBarChart stackedBarChart;
    private int occ_general, occ_emergency, occ_ICU, occ_private;
    private int vac_general, vac_emergency, vac_ICU, vac_private;
    @FXML
    private Label AdmitsNumber;
    @FXML
    private PieChart piechart;
    @FXML
    Button dashboard;
    private int occupancy, unoccupancy,numberOfbeds,rateOfOccupancy;
    @FXML
    Label userLabel;
    @FXML
    Label nurseLabel;

    
//    @FXML
//    private void Admittedvalue() throws SQLException {//label changes= calculates the number of patients from the database
//
//       DatabaseConnection connectnow = new DatabaseConnection();
//        DatabaseConnection.connectDb();
//        String query = "select count(*) from patient where p_allotment_status=1;";
//
//        PreparedStatement pnew = null;
//        int count;
//        count = pnew.executeUpdate(query);
//        pnew.executeQuery(query);
//        AdmitsNumber.setText(String.valueOf(count));
//   }
    public void setAdmitNumber() throws SQLException {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        Connection connectdb = databaseConnection.connectDb();
        Statement st;
        st = connectdb.createStatement();
        String query = "select count(*) from hbms_db.patient where p_allotment_status=1;";
        ResultSet rs;
        rs = st.executeQuery(query);
        rs.next();
        //displays number of rows returned after query execution
        AdmitsNumber.setText(String.valueOf(rs.getInt("count(*)")));
    }
    private void setStackedBarChart() throws SQLException {
        final XYChart.Series<String, Number> dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Occupied");
        occ_general = DatabaseConnection.getocc_general();
        occ_emergency = DatabaseConnection.getocc_emergency();
        occ_ICU = DatabaseConnection.getocc_icu();
        occ_private = DatabaseConnection.getocc_private();

        dataSeries1.getData().add(new XYChart.Data("General", occ_general));
        dataSeries1.getData().add(new XYChart.Data("Emergency", occ_emergency));
        dataSeries1.getData().add(new XYChart.Data("ICU", occ_ICU));
        dataSeries1.getData().add(new XYChart.Data("Private A", occ_private));


        final XYChart.Series<String, Number> dataSeries2 = new XYChart.Series();
        dataSeries2.setName("Vacant");
        vac_general = DatabaseConnection.getvac_general();
        vac_emergency = DatabaseConnection.getvac_emergency();
        vac_ICU = DatabaseConnection.getvac_icu();
        vac_private = DatabaseConnection.getvac_private();

        dataSeries2.getData().add(new XYChart.Data("General", vac_general));
        dataSeries2.getData().add(new XYChart.Data("Emergency", vac_emergency));
        dataSeries2.getData().add(new XYChart.Data("ICU", vac_ICU));
        dataSeries2.getData().add(new XYChart.Data("Private A", vac_private));


        stackedBarChart.getData().addAll(dataSeries1, dataSeries2);
    }


    public void Logout() throws IOException {
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
        Parent root = FXMLLoader.load((getClass().getResource("bed_ui.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    public void setAdmitsNumber() {
        try {
            setAdmitNumber();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void setUser() {
        String greetUser = " ";
        userLabel.setText(greetUser);

    }
    public void settotalNurse() throws SQLException {
        DatabaseConnection connectnow = new DatabaseConnection();
        Connection connectdb = connectnow.connectDb();
        Statement st1 = null;
        st1 = connectdb.createStatement();
        String query = "select count(*) from nurse where p_allotment_status=1;";
        ResultSet rs = null;
        rs = st1.executeQuery(query);
        rs.next();
        //displays number of rows returned after query execution
        nurseLabel.setText(String.valueOf(rs.getInt("count(*)")));
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            setUser();
            setAdmitNumber();
            //settotalNurse();

            // setlinechart();
            setPiechart();
            setStackedBarChart();
           // userlabelDisplay();

        } catch (SQLException e) {
            System.out.println("error in loading dashboard page!");
            System.out.println("error in loading dashboard page!");
            throw new RuntimeException(e);
        }
    }
    private void setPiechart() throws SQLException {
        //dashboard.setStyle("-fx-background-color: #f4f7f7; ");
        occupancy = DatabaseConnection.getOccupancy();
        unoccupancy = DatabaseConnection.getUnoccupancy();
        PieChart.Data a = new PieChart.Data("OCCUPIED", occupancy);
        PieChart.Data b = new PieChart.Data("VACANT", unoccupancy);

        piechart.getData().addAll(a, b);
        piechart.setLabelLineLength(50);
        piechart.setLegendSide(Side.LEFT);
    }

    private void setlinechart() {
        XYChart.Series series = new XYChart.Series();
        series.setName("BED OCCUPANCY RATE");

        series.getData().add(new XYChart.Data("jan", 15));
        series.getData().add(new XYChart.Data("may", 30));
        series.getData().add(new XYChart.Data("june", 60));
        series.getData().add(new XYChart.Data("september", 120));
        series.getData().add(new XYChart.Data("november", 240));
        series.getData().add(new XYChart.Data("december", 300));

        //Setting the data to Line chart

    }

    public void MOUSE_PRESSED(MouseEvent mouseEvent) {
        final Label caption = new Label("");
        caption.setTextFill(Color.WHITE);
        caption.setStyle("-fx-font: 24 arial;");
        for (final PieChart.Data data : piechart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent e) {
                            caption.setTranslateX(e.getSceneX());
                            caption.setTranslateY(e.getSceneY());
                            caption.setText(String.valueOf(data.getPieValue()) + "%");
                        }
                    });
        }
    }

    //@FXML
    //private Label label;

   /* public void usernameDisplay() {
        System.out.println("display user");
        label.setText(username);
    }

    */
}

