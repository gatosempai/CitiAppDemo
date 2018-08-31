package com.example.oscar.citiappdemo.presentation.view;

public interface MainActivityView {

    void showProgress();
    void hideProgress();
    void showError(String error);

    void setClientName(String clientName);
}
