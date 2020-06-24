package com.larrykim;

import com.larrykim.chap01.*;
import com.larrykim.chap02.Money.Money;
import com.larrykim.chap02.movice.*;
import com.larrykim.chap02.movice.pricing.*;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static Customer customer = new Customer("김유철","yoochul");

    static Movie movie = new Movie("왕의남자",
            Duration.ofMinutes(120),
            Money.wons(10000),
            new AmountDiscountPolicy(
                    Money.wons(800),
                    new SequenceCondition(1),
                    new SequenceCondition(2),
                    new PeriodCondition(
                            DayOfWeek.MONDAY,
                            LocalTime.of(9,00),
                            LocalTime.of(11,00)
                    )
            ));

    // 할인 조건에 해당되는 상영
    static Screening screening01 =
            new Screening(
                    movie, 1,
                    LocalDateTime.of(
                            LocalDate.of(2020,6,30),
                            LocalTime.of(10,00)
                    )
            );

    // 아무 할인조건에 해당되지 않는 상영
    static Screening screening02 =
            new Screening(
                    movie, 10,
                    LocalDateTime.of(
                            LocalDate.of(2020,6,30),
                            LocalTime.of(17,00)
                    )
            );

    public static void main(String[] args){

        // 넘어와야될거: 상영 영화, 고객, 몇명
        Reservation reservation1 = screening01.reserve(customer,2);
        System.out.println("상영01 영화 가격 = " + reservation1.getFee().toString()+"\n");

        Reservation reservation2 = screening02.reserve(customer,2);
        System.out.println("상영02 영화 가격 = " + reservation2.getFee().toString());
    }

}
