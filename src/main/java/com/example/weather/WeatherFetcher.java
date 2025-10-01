package com.example.weather;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.GsonBuilder;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.GsonBuilder;

public class WeatherFetcher {

    public static void main(String[] args) throws Exception {
        if(args.length == 0) {
            System.out.println("Please provide a city name.");
            return;
        }

        String city = args[0];
        String apiKey = System.getenv("OPENWEATHER_API_KEY");
        if(apiKey == null) {
            System.out.println("OPENWEATHER_API_KEY not set!");
            return;
        }

        String urlStr = "https://api.openweathermap.org/data/2.5/weather?q="
                        + city + "&appid=" + apiKey + "&units=metric";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if(conn.getResponseCode() != 200) {
                System.out.println("Error fetching weather: " + conn.getResponseCode());
                return;
            }

            InputStreamReader reader = new InputStreamReader(conn.getInputStream());
            JsonElement json = JsonParser.parseReader(reader);

            // Pretty-print JSON
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String prettyJson = gson.toJson(json);
            System.out.println(prettyJson);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
