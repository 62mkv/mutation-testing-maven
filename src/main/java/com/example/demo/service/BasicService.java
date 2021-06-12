package com.example.demo.service;

public class BasicService {
    public int provideService(String input) {
        fakeCall();
        return 5;
    }

    private int fakeCall() {
        return 1 + 1;
    }
}
