package com.example.moviebooking.comman;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordHashing {

    private static final BCryptPasswordEncoder encoder =
            new BCryptPasswordEncoder(12);

    public static String hash(String password) {
        return encoder.encode(password);
    }

}