package com.example.demo;


public class AuthResponse {
    private String token;
    AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
