package com.lipian.polishparliament.http;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class Http {

    public static <T> List<T> getList(Class<T> class_, String apiUrl) {
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                Type listType = TypeToken.getParameterized(List.class, class_).getType();
                return gson.fromJson(response.body(), listType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return List.of();
    }

    public static <T> T getObject(Class<T> class_, String apiUrl) {
        Gson gson = new Gson();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrl))
                .build();
        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200)
                return gson.fromJson(response.body(), class_);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
