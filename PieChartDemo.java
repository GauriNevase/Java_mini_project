package com.example.hopeitworks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Collections;

public class PieChartDemo extends HelloApplication{
        public ObservableList data;
        public void buildData(){
            Connection con;
            data= FXCollections.observableArrayList();
            try {
                con = DatabaseConnection.connectDb();
                //query for selecting occupancy and vacancy
                String query="select sum(b_occupancy=1)," +
                        "sum(b_occupancy=0)from bed;";
                ResultSet rs= con.createStatement().executeQuery(query);
                int a,b;
                while(rs.next()){
                    //adding data on pie chart data
                    data.add(new PieChart.Data(rs.getString(1),rs.getDouble(2)));
                }
            }catch (Exception e){
                System.out.println("error on piechart connection with database");
            }
        }
        @Override
        public void start(Stage stage) throws Exception {
            //PIE CHART
            PieChart pieChart = new PieChart();
            buildData();
            pieChart.getData().addAll(data);

            //Main Scene
            Scene scene = new Scene(pieChart);

            stage.setScene(scene);
            stage.show();
        }
    }


