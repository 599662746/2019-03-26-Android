package com.lenovo.test.httppost;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class OkHttp {

    public OkHttp(String canshu, String action, Callback callback) {

        String url = "http://10.10.0.79:8088/transportservice/action/"+action;

        MediaType mediaType = MediaType.parse("application/json,charset=utf_8");

        RequestBody requestBody = RequestBody.create(mediaType,canshu);

        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        OkHttpClient okHttpClient = new OkHttpClient();

        Call call = okHttpClient.newCall(request);

        call.enqueue(callback);

    }
}
