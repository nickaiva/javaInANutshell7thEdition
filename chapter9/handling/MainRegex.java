/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter9.handling;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 * @author nicka
 */
public class MainRegex {

    public static void main(String[] args) {
        String pStr = "\\d"; // A numeric digit
        String text = "Apollo 13";
        Pattern p = Pattern.compile(pStr);
        Matcher m = p.matcher(text);

        System.out.print(pStr + " matches " + text + "? " + m.find());

        System.out.println(" ; match: " + m.group());

        pStr = "[a..zA..Z]"; //Any letter
        p = Pattern.compile(pStr);

        m = p.matcher(text);

        System.out.print(pStr + " matches " + text + "? " + m.find());
        System.out.println(" ; match: " + m.group());
// Any number of letters, which must all be in the range 'a' to 'j'
// but can be upper or lowercase 
        pStr = "([a..jA..J]*)";

        p = Pattern.compile(pStr);
        m = p.matcher(text);
        System.out.print(pStr + " matches " + text + "? " + m.find());

        System.out.println(" ; match: " + m.group());

        text = "abacab";

// 'a' followed by any four characters, followed by 'b'
        pStr = "a....b";

        p = Pattern.compile(pStr);

        m = p.matcher(text);
        System.out.print(pStr + " matches " + text + "? " + m.find());

        System.out.println(" ; match: " + m.group());

        String poStr = "\\d"; // A numeric digit
        Pattern po = Pattern.compile(poStr);
        String[] inputs = {"Cat", "Dog", "Ice9", "99 Luftballoons"};
        List<String> ls = Arrays.asList(inputs);
        List<String> containDigits = ls.stream()
                .filter(po.asPredicate())
                .collect(Collectors.toList());
        System.out.println(containDigits);

    }

}
