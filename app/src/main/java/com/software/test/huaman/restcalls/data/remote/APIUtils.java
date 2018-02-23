package com.software.test.huaman.restcalls.data.remote;

/**
 * Created by kiwic on 2/22/2018.
 */

public class APIUtils {
    private APIUtils() {}

    public static final String BASE_URL = "https://sandbox.digital.visa.com";

    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
