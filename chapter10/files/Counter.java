/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter10.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author nicka
 */
public class Counter {

    public static void main(String[] args) {

        try (InputStream is = new FileInputStream("F:\\MyWork\\NetBeansProjects\\JavaInANutshell7th\\src\\chapter10\\files\\Counter.java")) {
            byte[] buf = new byte[4096];
            int len, count = 0;
            while ((len = is.read(buf)) > 0) {
                for (int i = 0; i < len; i++) {
                    if (buf[i] == 97) {
                        count++;
                    }
                }
            }
            File f = new File("F:\\MyWork\\NetBeansProjects\\JavaInANutshell7th\\src\\chapter10\\files");
            long free, total, usable;
            free = f.getFreeSpace();
            total = f.getTotalSpace();
            usable = f.getUsableSpace();
            System.out.println("'a's seen: " + count + " Bytes total " + total + " free " + free + " usable " + usable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
