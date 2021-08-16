/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter8.collection;

import java.util.function.IntSupplier;

/**
 *
 * @author nicka
 */
public class SquareGenerator implements IntSupplier {

    private int current = 1;

    @Override
    public synchronized int getAsInt() {
        int thisResult = current * current;
        current++;
        return thisResult;
    }

}
