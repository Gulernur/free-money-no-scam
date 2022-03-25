package com.example.freemoneynoscam.repositories;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    static Connection con;
    static Statement stmt;
    static String sqlString;
    static ResultSet rs;

    public DatabaseConnection(){
        connect();
    }

    public void submitEmailToDataBase(String email) {
        try {
            stmt = con.createStatement();

            sqlString = "INSERT INTO emails (`email`) " +
                    "VALUES ('" + email + "')";

            stmt.executeUpdate(sqlString);

        } catch (Exception e) {
            System.out.println("Oh no! Could not submit to database.");
            e.printStackTrace();
        }
    }

    public void connect () {
        String url = "jdbc:mysql://localhost:3306/free_money";

        try
        {
            con = DriverManager.getConnection(url,"root","testtest");
        }
        catch(Exception e)
        {
            System.out.println("Shit pommes frit, min DB connection virker ikke!!!!!!!!!");
        }

        System.out.println("URL: " + url);
        System.out.println("Vi har en connection. Jubiii!!!!!");
    }

    public String fetchSingleEmail(){

        String email = "";
        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            sqlString = "SELECT * FROM emails where id = '1'";

            ResultSet singleEmailResultSet = stmt.executeQuery(sqlString);
            singleEmailResultSet.next();
            email = singleEmailResultSet.getString(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return email;
    }

    public ArrayList<String> allEmails(){
        ArrayList<String> allEmails = new ArrayList<>();
        String email = "";

        try {
            stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

            sqlString = "SELECT * FROM emails";

            ResultSet allEmailResultSet = stmt.executeQuery(sqlString);
            while(allEmailResultSet.next()){
                email = allEmailResultSet.getString(2);
                allEmails.add(email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmails;

    }
}
