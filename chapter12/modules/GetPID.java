/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter12.modules;

/**
 *
 * @author nicka
 */
public class GetPID {

    public static void main(String[] args) {
        GetPID getpid = new GetPID();
        System.out.println("Process ID  "+ getpid.getPid());
    }

    public static long getPid() {
// Use new Java 9 Process API...
        ProcessHandle processHandle = ProcessHandle.current();
        return processHandle.pid();
    }
}
