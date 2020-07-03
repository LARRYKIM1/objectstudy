package com.larrykim.chap04.movie.step02_alone;

import com.larrykim.chap04.money.Money;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) { // 볼영화, 고객, 관람객 수
        Money fee = screening.calculateFee(audienceCount);
        return new Reservation(screening, customer, fee, audienceCount);
    }
}
