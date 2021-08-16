/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author nicka https://blog.codefx.org/java/five-command-line-options-hack-java-module-system/
 */
/* Compatible with versions from 1.8 and beyond 
by deleting any module-info.java
    by using the commands below:
 * javac --add-exports java.base/sun.text.resources=ALL-UNNAMED
    java --add-opens java.base/java.lang=ALL-UNNAMED
 */
package chapter12.nomodules;

import java.util.Arrays;
import sun.text.resources.FormatData;// Deprecated?

/**
 *
 * @author nicka
 */
public final class FormatStealer extends FormatData {

    public static void main(String[] args) {
        FormatStealer fs = new FormatStealer();
        fs.run();
    }

    private void run() {
        String[] s = (String[]) handleGetObject("japanese.Eras");
        System.out.println(Arrays.toString(s));
        Object[][] contents = getContents();
        Object[] eraData = contents[14];
        Object[] eras = (Object[]) eraData[1];
        System.out.println(Arrays.toString(eras));
    }

}
