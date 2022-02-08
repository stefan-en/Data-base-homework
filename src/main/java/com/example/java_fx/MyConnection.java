package com.example.java_fx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

import java.sql.*;

public class MyConnection {
    public static Connection ConnectDb(){
        String user = "bd159";
        String password = "bd195";
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@bd-dc.cs.tuiasi.ro:1539:orcl",user,password);
            System.out.println("Connected to database");
            return  conn;
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("I don't can make this connection"+e);
            e.printStackTrace();
            return null;
        }
    }


    public static ObservableList<Autovehicul> getAutovehicul() {
        Connection conn = ConnectDb();
        ObservableList<Autovehicul> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Autovehicule");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Autovehicul(Integer.parseInt(rs.getString("id_vehicul")), rs.getString("Denumire"), rs.getInt("Mentenanta"), rs.getInt("Rezervor"), rs.getInt("putere_nominala"), rs.getInt("putere_maxima"), (rs.getDate("anul_fabricatiei")), rs.getDate("Anul_achizitiei"), rs.getInt("id_sofer")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;

    }

    public static ObservableList<Utilaj> getUtilaj(){
        Connection conn = ConnectDb();
        ObservableList<Utilaj> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select *from Utilaj");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Utilaj(rs.getInt("id_utilaj"),rs.getString("denumire"),rs.getInt("putere_minim"),rs.getInt("mentenanta"),rs.getString("lucrari"),rs.getDouble("viteza"),(rs.getDate("anul_achizitiei")).toString(), (rs.getDate("anul_fabricatiei")).toString()));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static ObservableList<Teren> getTeren(){
        Connection conn = ConnectDb();
        ObservableList<Teren> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select *from Teren");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Teren(rs.getInt("id_teren"),rs.getString("denumire"),rs.getString("cultura"),rs.getString("stadiu"),rs.getString("fertilizare"),rs.getDouble("suprafata"),rs.getDouble("profit"),rs.getDouble("recolta")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public static ObservableList<Angajat> getAngajat(){
        Connection conn = ConnectDb();
        ObservableList<Angajat> list = FXCollections.observableArrayList();
        try {
            PreparedStatement ps = conn.prepareStatement("select *from Angajati");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(new Angajat(rs.getInt("id_angajat"),rs.getString("Nume"),rs.getDate("data_nasterii"),rs.getDate("data_angajarii"),rs.getString("cnp"),rs.getString("Rol"),rs.getInt("Worktime"),rs.getInt("Salariu"),rs.getString("categorii")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } return list;
    }
    public static ObservableList<Activitati> getActivitate(){
        Connection conn = ConnectDb();
        ObservableList<Activitati> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select *from Activitati");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new Activitati(rs.getDate("data_activitatii"),rs.getInt("terenul"),rs.getInt("autovehiculul"),rs.getInt("utilajul"),rs.getInt("angajat")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }return list;
    }
    public static ObservableList<ceva> getAutovehiculul(){
        Connection conn = ConnectDb();
        ObservableList<ceva> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select id_vehicul,denumire from autovehicule ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add((new ceva(rs.getInt("id_vehicul"),rs.getString("denumire"))));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;

    }
    public static ObservableList<ceva> getAngajatul(){
        Connection conn = ConnectDb();
        ObservableList<ceva> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select id_angajat, nume from angajati ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ceva(rs.getInt("id_angajat"),rs.getString("nume")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }
    public static ObservableList<ceva> getTerenul(){
        Connection conn = ConnectDb();
        ObservableList<ceva> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select id_teren, denumire from teren ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ceva(rs.getInt("id_teren"),rs.getString("denumire")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }
    public static ObservableList<ceva> getUtilajul(){
        Connection conn = ConnectDb();
        ObservableList<ceva> list = FXCollections.observableArrayList();
        try{
            PreparedStatement ps = conn.prepareStatement("select id_utilaj, denumire from utilaj ");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                list.add(new ceva(rs.getInt("id_utilaj"),rs.getString("denumire")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  list;
    }

}
