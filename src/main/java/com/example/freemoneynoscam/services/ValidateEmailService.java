package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.repositories.DatabaseConnection;

import java.util.ArrayList;

public class ValidateEmailService {

    private DatabaseConnection connection = new DatabaseConnection();

    public boolean isEmailValid(String email){

        if (email.contains("@") && email.contains(".") && email.length() > 5){
            return true;
        }

        return false;
    }

    public void submitEmail(String email){
        connection.submitEmailToDataBase(email);
    }

    public String getSingleEmail(){
        return connection.fetchSingleEmail();
    }

    public ArrayList<String> getAllEmails(){
        return connection.allEmails();
    }

}
