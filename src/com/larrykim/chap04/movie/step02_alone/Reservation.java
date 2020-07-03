package com.larrykim.chap04.movie.step02_alone;

import com.larrykim.chap04.money.Money;

public class Reservation { // 관람객, 상영영화=볼영화, 할인 적용된 가격, 관라객수
    private Screening screening;
    private Customer customer;
    private Money fee;
    private int audienceCount;

    public Reservation(Screening screening, Customer customer, Money fee, int audienceCount) {
        this.screening = screening;
        this.customer = customer;
        this.fee = fee;
        this.audienceCount = audienceCount;
    }

    @Override
    public String toString() {
        return "예약티켓 {" +
                "\n 고객이름=" + customer.toString() +
                "\n 상영정보=" + screening +
                "\n 할인 적용된 가격=" + fee +
                "\n 고객수=" + audienceCount +
                "\n}";
    }
}
