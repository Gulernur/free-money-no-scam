package com.example.freemoneynoscam.controllers;

import com.example.freemoneynoscam.repositories.DatabaseConnection;
import com.example.freemoneynoscam.services.ValidateEmailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import java.sql.Connection;
import java.sql.DriverManager;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/many_money")
    public String manyMoney(){
        return "many_money";
    }

    @PostMapping("/test")
    public String test(WebRequest dataFromForm){
        ValidateEmailService validate = new ValidateEmailService();

        System.out.println(dataFromForm.getParameter("email"));
        String email = dataFromForm.getParameter("email");

        if(validate.isEmailValid(email) == true){
            validate.submitEmail(email);
            return "many_money";
        } else {
            System.out.println("nono, honeeeeey");
        }

        return "redirect:/";
    }





}
