/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter9.handling;

import java.time.LocalDate;
import java.time.Month;
import java.time.YearMonth;
import java.time.temporal.IsoFields;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 *
 * @author nicka
 */
public class FirstDayOfQuarter implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        
        final int currentQuarter = YearMonth.from(temporal).get(IsoFields.QUARTER_OF_YEAR);
        
        switch (currentQuarter) {
            case 1:
                return LocalDate.from(temporal).with(TemporalAdjusters.firstDayOfYear());
            case 2:
                return LocalDate.from(temporal).withMonth(Month.APRIL.getValue()).with(TemporalAdjusters.firstDayOfMonth());
            case 3:
                return LocalDate.from(temporal).withMonth(Month.JULY.getValue()).with(TemporalAdjusters.firstDayOfMonth());
            case 4:
                return LocalDate.from(temporal).withMonth(Month.OCTOBER.getValue()).with(TemporalAdjusters.firstDayOfMonth());
            default:
                return null; // Will never happen
        }

    }
    
    public static void main(String[] args){
        
        LocalDate now = LocalDate.now();
        Temporal fdoq = now.with(new FirstDayOfQuarter());
        System.out.println("FirstDayOfQuarter " + fdoq);
    }

}
