/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter9.handling;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author nicka
 */
public class MainNumber {

    public static void main(String[] args) {

        byte b = 0b0000_0001;

        System.out.println(b);
        // 1
        b = 0b0000_0010;

        System.out.println(b);
        // 2
        b = 0b0000_0011;
        System.out.println(b);
        // 3
        b = 0b0111_1111;
        System.out.println(b);
        b = 0b0100_0000;
        System.out.println(b);//64
        b = (byte) 0b1111_1111; // -1
        System.out.println(b);
        b++;
        System.out.println(b);
        b = (byte) 0b1111_1110; // -2
        System.out.println(b);
        b++;
        System.out.println(b);
        b = (byte) 0b1000_0000;
        System.out.println(b); // -128
        double d = 0.3;
        System.out.println(d); // Specialcased to avoid ugly representation
        double d2 = 0.2;
// Should be 0.1       but prints -0.09999999999999998
        System.out.println(d2 - d);
        double d1 = 0.3;
        System.out.println(d1);
        BigDecimal bd = new BigDecimal(d1);
        System.out.println(bd);
        bd = new BigDecimal("0.3");
        System.out.println(bd);
        
        bd = new BigDecimal(BigInteger.ONE);
        bd.divide(new BigDecimal(3.0));
        System.out.println(bd); // Should be 1/3

    }

}
