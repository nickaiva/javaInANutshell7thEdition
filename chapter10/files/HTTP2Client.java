/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10.files;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import static java.net.http.HttpResponse.BodyHandlers.ofString;
import java.nio.charset.Charset;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

/**
 *
 * @author nicka
 */
public class HTTP2Client {

    public static void main(String[] args) {

        var client = HttpClient.newBuilder().build();
        try {
            var uri = new URI("https://www.bbc.co.uk/search?q=Greece");

            var request = HttpRequest.newBuilder(uri).build();
            var response = client.send(request,
                    ofString(Charset.defaultCharset()));
            var body = response.body();
            System.out.println(body);
        } catch (IOException | InterruptedException | URISyntaxException e) {
            e.printStackTrace();
        }

    }
}
