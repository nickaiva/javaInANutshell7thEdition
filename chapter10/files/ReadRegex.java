/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author nicka
 */
public class ReadRegex {

    public static void main(String[] args) {
        Pattern SHELL_META_START = Pattern.compile("^\\W(\\w+)\\s*(\\w+)?");//^#(\\w+)\\s*(\\w+)?
        try (BufferedReader console
                = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            READ:  while ((line = console.readLine()) != null && !"0".equals(line)) {
// Check for special commands ("metas")
                Matcher m = SHELL_META_START.matcher(line);
                if (m.find()) {
                    String metaName = m.group(1);
                    String arg = m.group(2);
                    //System.out.println("meta entered: " + metaName + " Text "+ arg);
                    doMeta(metaName, arg);
                    continue READ;
                }
                System.out.println("Text entered: "+line );
            }
        } catch (IOException e) {
// Handle FileNotFoundException, etc. here
        e.printStackTrace();
        }
    }

    public static void doMeta(String metaName, String arg) {
        System.out.println("Plain text: "+ arg + " special commands: " + metaName);
        
    }

}
