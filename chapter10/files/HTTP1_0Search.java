/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10.files;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * HTTP 1.0 IS DEPRECATED
 *
 * @author nicka
 */
public class HTTP1_0Search {

    public static void main(String[] args) throws MalformedURLException, UnsupportedEncodingException, IOException {

        URL url = new URL("https://www.kathimerini.gr/search?q=sword");//
        String encodedData = URLEncoder.encode("&Technologies", StandardCharsets.UTF_8.toString());//This statement may fail results do not include "string  arguments given"
        System.out.println("Complete Url " + url + encodedData);
        //downloadURL(url,encodedData);
        String contentType = "application/x-www-form-urlencoded";
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", contentType);
        conn.setRequestProperty("Content-Length", String.valueOf(encodedData.length()));
        conn.setDoOutput(true);
        OutputStream os = conn.getOutputStream();
        os.write(encodedData.getBytes());
        int response = conn.getResponseCode();
        if (response == HttpURLConnection.HTTP_MOVED_PERM
                || response == HttpURLConnection.HTTP_MOVED_TEMP) {
            System.out.println("Moved to: " + conn.getHeaderField("Location"));
        } else {
            try (InputStream in = conn.getInputStream()) {
                Files.copy(in, Paths.get("searchResults.html"),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        }

    }

    private static void downloadURL(URL url, String query) throws MalformedURLException, UnsupportedEncodingException {
        
          
        String encodedData = URLEncoder.encode(query, StandardCharsets.UTF_8.toString());//This statement fails results do not include "query arguments given"
        System.out.println("Complete Url " + url + encodedData);
        try (InputStream in = url.openStream()) {
            Files.copy(in, Paths.get("searchResults2.html"),
                    StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException ex) {
            ex.printStackTrace();

        }
    }
}
