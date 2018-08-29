package com.example.oscar.citiappdemo.data.remote.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GetClientNameResponse {
    @SerializedName("faultcode")
    @Expose
    private String faultcode;
    @SerializedName("clientName")
    @Expose
    private String clientName;
    @SerializedName("faultstring")
    @Expose
    private String faultstring;
    @SerializedName("resultCode")
    @Expose
    private String resultCode;
    @SerializedName("statusEB")
    @Expose
    private String statusEB;
    @SerializedName("opstatus")
    @Expose
    private String opstatus;

    public String getFaultcode() {
        return faultcode;
    }

    public void setFaultcode(String faultcode) {
        this.faultcode = faultcode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getFaultstring() {
        return faultstring;
    }

    public void setFaultstring(String faultstring) {
        this.faultstring = faultstring;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getStatusEB() {
        return statusEB;
    }

    public void setStatusEB(String statusEB) {
        this.statusEB = statusEB;
    }

    public String getOpstatus() {
        return opstatus;
    }

    public void setOpstatus(String opstatus) {
        this.opstatus = opstatus;
    }
}
