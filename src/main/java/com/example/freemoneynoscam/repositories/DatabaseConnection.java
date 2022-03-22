package com.example.freemoneynoscam.repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {

    static Connection con;
    static Statement stmt;
    static String sqlString;


    public void submitEmailToDataBase(String email) {
        connect();

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
            con = DriverManager.getConnection(url,"root","");
        }
        catch(Exception e)
        {
            System.out.println("Shit pommes frit, min DB connection virker ikke!!!!!!!!!");
        }

        System.out.println("URL: " + url);
        System.out.println("Vi har en connection. Jubiii!!!!!");
    }
}
