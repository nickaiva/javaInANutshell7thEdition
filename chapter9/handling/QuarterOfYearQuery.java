/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter9.handling;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

/**
 *
 * @author nicka
 */
public class QuarterOfYearQuery implements TemporalQuery<Quarter> {

    @Override
    public Quarter queryFrom(TemporalAccessor temporal) {
        LocalDate now = LocalDate.from(temporal);
        System.out.println(now);
        if (now.isBefore(now.with(Month.APRIL).withDayOfMonth(1))) {
            return Quarter.FIRST;
        } else if (now.isBefore(now.with(Month.JULY)
                .withDayOfMonth(1))) {
            return Quarter.SECOND;
        } else if (now.isBefore(now.with(Month.NOVEMBER)
                .withDayOfMonth(1))) {
            return Quarter.THIRD;
        } else {
            return Quarter.FOURTH;

        }
    }

    public static void main(String[] args) {
        QuarterOfYearQuery q = new QuarterOfYearQuery();
// Direct
        Quarter quarter = q.queryFrom(LocalDate.now());
        System.out.println(quarter);
// Indirect
        quarter = LocalDate.now().query(q);
        System.out.println(quarter);
    }
}
