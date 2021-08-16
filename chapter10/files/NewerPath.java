/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10.files;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author nicka
 */
public class NewerPath {

    public static void main(String[] args) throws URISyntaxException {
        Path p = Paths.get("/Users/ben/cluster.txt");
        Path p2 = Paths.get(new URI("file:///Users/ben/cluster.txt"));
        System.out.println(p2.equals(p));
        File f = p.toFile();
        System.out.println(f.isDirectory());
        Path p3 = f.toPath();
        System.out.println(p3.equals(p));
    }

}
