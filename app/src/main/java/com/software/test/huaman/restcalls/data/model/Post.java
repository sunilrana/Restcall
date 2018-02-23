package com.software.test.huaman.restcalls.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by kiwic on 2/22/2018.
 */


public class Post {

    @SerializedName("host")
    @Expose
    private String host;
    @SerializedName("contentType")
    @Expose
    private String contentType;
    @SerializedName("xRequestId")
    @Expose
    private String xRequestId;
    @SerializedName("body")
    @Expose
    private String body;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getxRequestId() {
        return xRequestId;
    }

    public void setxRequestId(String xRequestId) {
        this.xRequestId = xRequestId;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}