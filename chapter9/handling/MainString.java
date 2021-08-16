package chapter9.handling;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nicka
 */
public class MainString {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String s1 = "AB";
        String s2 = "CD";
        String s3 = s1;
        System.out.println(s1 == s3); // Same object
        s3 = s1 + s2;
        System.out.println(s1 == s3);// Still same?
        System.out.println(s1);
        System.out.println(s3);
    }

}
