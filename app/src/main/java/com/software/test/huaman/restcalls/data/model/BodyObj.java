package com.software.test.huaman.restcalls.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kiwic on 2/22/2018.
 */

public class BodyObj {
    @SerializedName("consumerEntryMode")
    @Expose
    private String consumerEntryMode;
    @SerializedName("panSource")
    @Expose
    private String panSource;
    @SerializedName("clientDeviceId")
    @Expose
    private String clientDeviceId;

    @SerializedName("encPaymentInstrument")
    @Expose
    private String encPaymentInstrument;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("clientWalletAccountId")
    @Expose
    private String clientWalletAccountId;
    @SerializedName("ClientAppId")
    @Expose
    private String ClientAppId;

    public String getConsumerEntryMode() {
        return consumerEntryMode;
    }

    public void setConsumerEntryMode(String consumerEntryMode) {
        this.consumerEntryMode = consumerEntryMode;
    }

    public String getPanSource() {
        return panSource;
    }

    public void setPanSource(String panSource) {
        this.panSource = panSource;
    }

    public String getClientDeviceId() {
        return clientDeviceId;
    }

    public void setClientDeviceId(String clientDeviceId) {
        this.clientDeviceId = clientDeviceId;
    }

    public String getEncPaymentInstrument() {
        return encPaymentInstrument;
    }

    public void setEncPaymentInstrument(String encPaymentInstrument) {
        this.encPaymentInstrument = encPaymentInstrument;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getClientWalletAccountId() {
        return clientWalletAccountId;
    }

    public void setClientWalletAccountId(String clientWalletAccountId) {
        this.clientWalletAccountId = clientWalletAccountId;
    }

    public String getClientAppId() {
        return ClientAppId;
    }

    public void setClientAppId(String clientAppId) {
        ClientAppId = clientAppId;
    }
}
