package com.example.freemoneynoscam.services;

import com.example.freemoneynoscam.repositories.DatabaseConnection;

public class ValidateEmailService {
    public boolean isEmailValid(String email){

        if (email.contains("@") && email.contains(".") && email.length() > 5){
            return true;
        }

        return false;
    }

    public void submitEmail(String email){
        DatabaseConnection connection = new DatabaseConnection();
        connection.submitEmailToDataBase(email);
    }

}
