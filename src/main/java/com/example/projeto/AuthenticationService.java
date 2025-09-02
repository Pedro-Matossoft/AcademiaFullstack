package com.example.projeto;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean Autheticate(String username, String password){

        // ADMIN
        boolean isAdminUsername = username.equalsIgnoreCase("Admin");
        boolean isAdminPassword = password.equalsIgnoreCase("Admin");

        // USER
        boolean isValidUsername = username.equalsIgnoreCase("User");
        boolean isValidPassword = password.equalsIgnoreCase("User");

        return  isAdminUsername && isAdminPassword || isValidUsername && isValidPassword;
    }
}