package com.education.myanimation.httputils;


import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HttpUtils {
    private static HttpUtils instance;

    private HttpUtils() {
    }

    public static synchronized HttpUtils getInstance() {
        //
        if (instance == null) {
            instance = new HttpUtils();
        }
        return instance;
    }
}
