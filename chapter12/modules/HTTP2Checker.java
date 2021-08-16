/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12.modules;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import static java.net.http.HttpResponse.BodyHandlers.ofString;
import java.nio.charset.Charset;

/**
 *
 * @author nicka
 */
public final class HTTP2Checker {

    public static void main(String[] args) throws Exception {
        
        if (args.length == 0) {
            System.err.println("Provide URLS to check");

        }
        for (final var location : args) {
            var client = HttpClient.newBuilder().build();

            var uri = new URI(location);

            var req = HttpRequest.newBuilder(uri).build();

            var response = client.send(req,
                    ofString(Charset.defaultCharset()));

            System.out.println(location + ": " + response.version());

        }
    }
}
