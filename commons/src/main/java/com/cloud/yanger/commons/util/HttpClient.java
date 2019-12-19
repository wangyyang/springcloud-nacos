package com.cloud.yanger.commons.util;

import okhttp3.*;
import okio.Buffer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;
import java.util.Set;

public class HttpClient {
    private static HttpClient httpClient = new HttpClient();

    public static HttpClient getInstance() {
        return httpClient;
    }

    private OkHttpClient client;

    {
        client = new OkHttpClient.Builder()
//                .addInterceptor(new LoggingInterceptor())
                .build();
    }


    public String post(String url, Map<String, String> params, String... headers) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                builder.add(key, params.get(key));
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .headers(Headers.of(headers))
                .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response postForResponse(String url, Map<String, Object> params, String... headers) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null) {
            Set<String> keys = params.keySet();
            for (String key : keys) {
                builder.add(key, params.get(key).toString());
            }
        }
        Request request = new Request.Builder()
                .url(url)
                .post(builder.build())
                .headers(Headers.of(headers))
                .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public Response postForObject(String url, Object entry, String... headers) {
        MediaType mt = MediaType.parse("application/json; charset=utf-8");
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(mt, JSONUtils.toJson(entry)))
                .headers(Headers.of(headers))
                .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String postForJSON(String url, Object entry, String... headers) {
        MediaType mt = MediaType.parse("application/json; charset=utf-8");
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(mt, JSONUtils.toJson(entry)))
                .headers(Headers.of(headers))
                .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String postForString(String url, String str, String... headers) {
        MediaType mt = MediaType.parse("text/plain; charset=utf-8");
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(mt, str))
                .headers(Headers.of(headers))
                .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String get(String url, Map<String, String> params, String... headers) {
        url = appendParams(url, params);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .headers(Headers.of(headers))
                .build();
        Response response;
        try {
            response = client.newCall(request).execute();
            return response.body().string();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String appendParams(String url, Map<String, String> params) {
        if (url == null || params == null || params.isEmpty()) {
            return url;
        }
        try {
            HttpUrl httpUrl = HttpUrl.get(new URI(url));
            if (httpUrl == null) return url;
            HttpUrl.Builder builder = httpUrl.newBuilder();
            Set<String> keys = params.keySet();
            for (String key : keys) {
                builder.addQueryParameter(key, params.get(key)).build();
            }
            return builder.toString();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return url;
    }


    class LoggingInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Buffer buffer = new Buffer();
            RequestBody requestBody = request.body();
            if (requestBody != null) {
                requestBody.writeTo(buffer);
            }
            Response response = chain.proceed(request);
            return response;
        }
    }
}
