package com.example.oscar.citiappdemo.data.remote.models;

public class GetClientNameRequest {
    private String clientNumber;

    public GetClientNameRequest(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getClientNumber() {
        return clientNumber;
    }
}
