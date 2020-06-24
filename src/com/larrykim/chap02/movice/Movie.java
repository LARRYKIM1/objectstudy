package com.larrykim.chap02.movice;

import com.larrykim.chap02.Money.Money;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private DiscountPolicy discountPolicy;

    public Movie(String title, Duration runningTime, Money fee, DiscountPolicy discountPolicy) {
        this.title = title;
        this.runningTime = runningTime;
        this.fee = fee;
        this.discountPolicy = discountPolicy;
    }

    public Money getFee() {
        return fee;
    }

    public Money calculateMovieFee(Screening screening) {
        System.out.println("Movie의 calculateMovieFee 실행합니다.");
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }

}
