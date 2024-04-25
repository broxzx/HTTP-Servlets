package com.project.client;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public class UrlExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com");
        URLConnection urlConnection = url.openConnection();
        urlConnection.setDoOutput(true);

        try (OutputStream outputStream = urlConnection.getOutputStream()) {
            outputStream.write("GET / HTTP/1.1\n".getBytes());

            
        }
    }
}
