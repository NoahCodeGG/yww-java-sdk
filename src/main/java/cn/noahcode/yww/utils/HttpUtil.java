package cn.noahcode.yww.utils;

import okhttp3.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author NoahCode
 * @date 2020/4/22
 * @description
 */
public class HttpUtil {
    private static OkHttpClient okHttpClient;
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    static {
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    public static String get(String url, Map<String, String> params) throws Exception {
        StringBuilder sb = new StringBuilder();
        if (params != null && params.size() > 0) {
            Set<Map.Entry<String, String>> entrySet = params.entrySet();
            sb.append("?");
            for (Map.Entry<String, String> entry : entrySet) {
                sb.append(entry.getKey());
                sb.append("=");
                try {
                    sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                sb.append("&");
            }
            sb.deleteCharAt(sb.length() - 1);
        }
        Request request = new Request.Builder().url(url + sb.toString()).get().build();
        Call call = okHttpClient.newCall(request);
        try {
            return call.execute().body().string();
        } catch (IOException e) {
            throw e;
        }
    }

    public static String post(String url, String jsonMsg) {
        RequestBody body = RequestBody.create(jsonMsg, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        try (Response response = okHttpClient.newCall(request).execute()) {
            return response.body().string();
        } catch (IOException e) {
            return "";
        }
    }
}
