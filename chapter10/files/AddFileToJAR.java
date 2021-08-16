/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10.files;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *manipulate a JAR file as a FileSystem in its own
right, modifying it to add an additional file directly into the JAR
 * @author nicka
 */
public class AddFileToJAR {

    public static void main(String[] args) throws IOException {

        Path tempJar = Paths.get("F:\\MyWork\\NetBeansProjects\\JavaInANutshell7th\\dist\\JavaInANutshell7th.jar");
        try (FileSystem workingFS
                = FileSystems.newFileSystem(tempJar, null)) {
            Path pathForFile = workingFS.getPath("/licence.txt");
            List<String> ls = new ArrayList<>();
            ls.add("License terms");
            Files.write(pathForFile, ls, Charset.defaultCharset(),
                    StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        }
    }

}
