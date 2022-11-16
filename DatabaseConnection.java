package com.example.hopeitworks;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.sql.*;

public class DatabaseConnection {


    public static Connection connectDb() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/hbms_db", "root", "Gauri@18");

            return connect;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Database connection failure!");
        }
        return null;
    }

    public static ObservableList<patientinfomodel> getData() {
        ObservableList<patientinfomodel> list = FXCollections.observableArrayList();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectDb();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("select \n" +
                    "bed.b_id, room.rc_name,patient.p_id,patient.p_name,patient.p_admission\n" +
                    "from patient right join bed on bed.b_id=patient.b_id\n" +
                    "JOIN room\n" +
                    "ON room.r_id = bed.r_id\n" +
                    "where p_allotment_status = 1");
            while (rs.next()) {
                // number of parameter depends upon columns in table view
                list.add(new patientinfomodel(rs.getInt("p_id"), rs.getString("p_name"), rs.getString("rc_name"), rs.getString("b_id"), rs.getString("p_admission")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public static ObservableList<PieChartDemo> Data() throws SQLException {
        ObservableList<PieChartDemo> list = FXCollections.observableArrayList();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectDb();
            Statement statement = connectDB.createStatement();
            String query = "select sum(b_occupancy=1)," +
                    "sum(b_occupancy=0)from bed;";
            ResultSet rs = connectDB.createStatement().executeQuery(query);
        } catch (Exception e) {
            System.out.println("error!");
        }
        return list;
    }

    public static int getOccupancy() throws SQLException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectDb();
        Statement statement = connectDB.createStatement();
        int count = 0;
        String query = "SELECT COUNT(*) FROM bed where b_occupancy=1;";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    public static int getUnoccupancy() throws SQLException {

        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectDb();
        Statement statement = connectDB.createStatement();
        int count = 0;
        String query = "SELECT COUNT(*) FROM bed where b_occupancy=0;";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    public static int getNUmberOfBeds() throws SQLException {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.connectDb();
        Statement statement = connectDB.createStatement();
        int count = 0;
        String query = "select count(*) from bed;";
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            count = rs.getInt(1);
        }
        return count;
    }

    public static ObservableList<bedinfomodel> getInfo() {
        ObservableList<bedinfomodel> list = FXCollections.observableArrayList();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectDb();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("select \n" +
                    "bed.b_id,patient.p_id,bed.b_occupancy,patient.p_age,patient.p_name\n" +
                    "from patient right join bed on bed.b_id=patient.b_id\n" +
                    "JOIN room\n" +
                    "ON room.r_id = bed.r_id\n" +
                    "where room.rc_name='general';");
            while (rs.next()) {
                // number of parameter depends upon columns in table view
                list.add(new bedinfomodel(rs.getInt("b_id"), rs.getString("p_name"), rs.getInt("p_id"), rs.getInt("b_occupancy"), rs.getInt("p_age")));
            }
        } catch (SQLException e) {
             throw new RuntimeException(e);
        }

        return list;
    }

    public static ObservableList<bedinfomodel> getInfo2() {
        ObservableList<bedinfomodel> list = FXCollections.observableArrayList();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectDb();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("select\n" +
                    "\t\tbed.b_id,patient.p_id,patient.p_age,bed.b_occupancy,patient.p_name\n" +
                    "                    from patient right join bed on bed.b_id=patient.b_id\n" +
                    "                    JOIN room\n" +
                    "                    ON room.r_id = bed.r_id\n" +
                    "                    where room.rc_name='emergency';");
            while (rs.next()) {
                // number of parameter depends upon columns in table view
                list.add(new bedinfomodel(rs.getInt("b_id"), rs.getString("p_name"), rs.getInt("p_id"), rs.getInt("b_occupancy"), rs.getInt("p_age")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public static ObservableList<bedinfomodel> getInfo3() {
        ObservableList<bedinfomodel> list = FXCollections.observableArrayList();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectDb();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("select\n" +
                    "\t\tbed.b_id,patient.p_id,patient.p_age,bed.b_occupancy,patient.p_name\n" +
                    "                    from patient right join bed on bed.b_id=patient.b_id\n" +
                    "                    JOIN room\n" +
                    "                    ON room.r_id = bed.r_id\n" +
                    "                    where room.rc_name='ICU';");
            while (rs.next()) {
                // number of parameter depends upon columns in table view
                list.add(new bedinfomodel(rs.getInt("b_id"), rs.getString("p_name"), rs.getInt("p_id"), rs.getInt("b_occupancy"), rs.getInt("p_age")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    public static ObservableList<bedinfomodel> getInfo4() {
        ObservableList<bedinfomodel> list = FXCollections.observableArrayList();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectDb();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("select\n" +
                    "\t\tbed.b_id,patient.p_id,patient.p_age,bed.b_occupancy,patient.p_name\n" +
                    "                    from patient right join bed on bed.b_id=patient.b_id\n" +
                    "                    JOIN room\n" +
                    "                    ON room.r_id = bed.r_id\n" +
                    "                    where room.rc_name='private A';");
            while (rs.next()) {
                // number of parameter depends upon columns in table view
                list.add(new bedinfomodel(rs.getInt("b_id"), rs.getString("p_name"), rs.getInt("p_id"), rs.getInt("b_occupancy"), rs.getInt("p_age")));
            }
        } catch (SQLException e) {
            // throw new RuntimeException(e);
        }
        return list;
    }
    public static ObservableList<bedinfomodel> getInfo5() {
        ObservableList<bedinfomodel> list = FXCollections.observableArrayList();
        try {
            DatabaseConnection connectNow = new DatabaseConnection();
            Connection connectDB = connectNow.connectDb();
            Statement statement = connectDB.createStatement();
            ResultSet rs = statement.executeQuery("select\n" +
                    "\t\tbed.b_id,patient.p_id,patient.p_age,bed.b_occupancy,patient.p_name\n" +
                    "                    from patient right join bed on bed.b_id=patient.b_id\n" +
                    "                    JOIN room\n" +
                    "                    ON room.r_id = bed.r_id\n" +
                    "                    where room.rc_name='private B';");
            while (rs.next()) {
                // number of parameter depends upon columns in table view
                list.add(new bedinfomodel(rs.getInt("b_id"), rs.getString("p_name"), rs.getInt("p_id"), rs.getInt("b_occupancy"), rs.getInt("p_age")));
            }
        } catch (SQLException e) {
            // throw new RuntimeException(e);
        }
        return list;
    }

    static void delete(Integer id) throws SQLException {

        String p_id = String.valueOf(id);
        String query = "UPDATE `hbms_new`.`patient` SET `p_allotment_status` = 0  WHERE `b_id` = " + p_id + "" ;
        //System.out.println(query);
        String query1 = "UPDATE `hbms_new`.`bed` SET `b_occupancy` = 0 WHERE `b_id` = "+ p_id+";";
        PreparedStatement preparedStatement = connectDb().prepareStatement(query);
        PreparedStatement preparedStatement1 = connectDb().prepareStatement(query1);
        int status = preparedStatement.executeUpdate();
        int status1 = preparedStatement1.executeUpdate();
        if(status!=0) {
            //System.out.println("Doctor Deleted Successfully!");
        }

    }
    public static int getocc_general() throws SQLException {
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.connectDb();
        Statement statement=connectDB.createStatement();
        int count=0;
        String query="select count(b_id) from bed where r_id=1 AND b_occupancy=1;";
        ResultSet rs= statement.executeQuery(query);
        while(rs.next()){count=rs.getInt(1);}
        return count;}

    public static int getocc_icu() throws SQLException {
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.connectDb();
        Statement statement=connectDB.createStatement();
        int count=0;
        String query="select count(b_id) from bed where (r_id=2 or r_id=3) AND b_occupancy=1;";
        ResultSet rs= statement.executeQuery(query);
        while(rs.next()){count=rs.getInt(1);}
        return count;
    }

    public static int getocc_emergency() throws SQLException {
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.connectDb();
        Statement statement=connectDB.createStatement();
        int count=0;
        String query="select count(b_id) from bed where r_id=4 AND b_occupancy=1;";
        ResultSet rs= statement.executeQuery(query);
        while(rs.next()){count=rs.getInt(1);}
        return count;
    }

    public static int getocc_private() throws SQLException {
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.connectDb();
        Statement statement=connectDB.createStatement();
        int count=0;
        String query="select count(b_id) from bed where (r_id=5 or r_id=6 or r_id=7 or r_id=8)  AND b_occupancy=1;";
        ResultSet rs= statement.executeQuery(query);
        while(rs.next()){count=rs.getInt(1);}
        return count;
    }

    public static int getvac_general() throws SQLException {
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.connectDb();
        Statement statement=connectDB.createStatement();
        int count=0;
        String query="select count(b_id) from bed where r_id=1  AND b_occupancy=0;";
        ResultSet rs= statement.executeQuery(query);
        while(rs.next()){count=rs.getInt(1);}
        return count;
    }

    public static int getvac_icu() throws SQLException {
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.connectDb();
        Statement statement=connectDB.createStatement();
        int count=0;
        String query="select count(b_id) from bed where (r_id=2 or r_id=3) AND b_occupancy=0;";
        ResultSet rs= statement.executeQuery(query);
        while(rs.next()){count=rs.getInt(1);}
        return count;
    }

    public static int getvac_emergency() throws SQLException {
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.connectDb();
        Statement statement=connectDB.createStatement();
        int count=0;
        String query="select count(b_id) from bed where r_id=4 AND b_occupancy=0;";
        ResultSet rs= statement.executeQuery(query);
        while(rs.next()){count=rs.getInt(1);}
        return count;
    }

    public static int getvac_private() throws SQLException {
        DatabaseConnection connectNow=new DatabaseConnection();
        Connection connectDB=connectNow.connectDb();
        Statement statement=connectDB.createStatement();
        int count=0;
        String query="select count(b_id) from bed where (r_id=5 or r_id=6 or r_id=7 or r_id=8)  AND b_occupancy=0;";
        ResultSet rs= statement.executeQuery(query);
        while(rs.next()){count=rs.getInt(1);}
        return count;
    }
}
