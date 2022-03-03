package glovis.util;

import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Translator {
    // This translator using whatsmate
    // active until 2020-04-03
    private static final String CLIENT_ID = "yusufhabibi1998@gmail.com";
    private static final String CLIENT_SECRET = "aaa06e697f5e48b3820342903c2ecb29";
    private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";

    /**
     * Entry Point
     */
    public static void main(String[] args) throws Exception {
        // TODO: Specify your translation requirements here:
        String fromLang = "en";
        String toLang = "es";
        String text = "Let's have some fun!";

        Translator.translate(fromLang, toLang, text);
    }

    /**
     * Sends out a WhatsApp message via WhatsMate WA Gateway.
     */
    public static String translate(String fromLang, String toLang, String text) throws Exception {
        if(toLang.equalsIgnoreCase("en")){
            return text;
        }
        // TODO: Should have used a 3rd party library to make a JSON string from an object
        String jsonPayload = new StringBuilder()
                .append("{")
                .append("\"fromLang\":\"")
                .append(fromLang)
                .append("\",")
                .append("\"toLang\":\"")
                .append(toLang)
                .append("\",")
                .append("\"text\":\"")
                .append(text)
                .append("\"")
                .append("}")
                .toString();

        URL url = new URL(ENDPOINT);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
        conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
        conn.setRequestProperty("Content-Type", "application/json");

        OutputStream os = conn.getOutputStream();
        os.write(jsonPayload.getBytes());
        os.flush();
        os.close();

        int statusCode = conn.getResponseCode();
        System.out.println("Status Code: " + statusCode);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()
        ));
        String output;
        String result="";
        while ((output = br.readLine()) != null) {
            System.out.println(output);
            result += output;
        }
        conn.disconnect();

        return result;
    }

}
