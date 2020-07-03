package com.larrykim.chap04.movie.step02_alone;

import com.larrykim.chap04.money.Money;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Movie { // 이름, 러닝 타임, 요금, 할인 조건(퍼센트,특정 금액)
    private String title;
    private Duration duration;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private double discountPercent;

    public Movie(String title, Duration duration, Money fee, int discountAmount, DiscountCondition... discountConditions) {
        this(MovieType.AMOUNT_DISCOUNT, title, duration, fee, Money.wons(discountAmount), 0, discountConditions);
    }

    public Movie(String title, Duration duration, Money fee, double discountPercent, DiscountCondition... discountConditions) {
        this(MovieType.PERCENT_DISCOUNT, title, duration, fee, Money.ZERO, discountPercent, discountConditions);
    }

    public Movie(String title, Duration duration, Money fee, DiscountCondition... discountConditions) {
        this(MovieType.NONE_DISCOUNT, title, duration, fee, Money.ZERO, 0, discountConditions);
    }

    public Movie(MovieType movieType, String title, Duration duration, Money fee, Money discountAmount, double discountPercent, DiscountCondition... discountConditions) {
        this.title = title;
        this.duration = duration;
        this.fee = fee;
        this.movieType = movieType;
        this.discountAmount = discountAmount;
        this.discountPercent = discountPercent;
        this.discountConditions = Arrays.asList(discountConditions);
    }

    @Override
    public String toString() {
        return " {" +
                "\n\t제목='" + title + '\'' +
                "\n\t러닝타임=" + duration +
                "\n\t기본요금=" + fee +
                "\n\t적용된 할인 정책=" + discountConditions.toString() +
                "\n\t할인정책타입=" + movieType +
                "\n\t할인금액=" + discountAmount +
                "\n\t할인비율=" + discountPercent +
                '}';
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public Money calculateAmountDiscountedFee() {
        if (movieType != MovieType.AMOUNT_DISCOUNT)
            throw new IllegalStateException();

        return fee.minus(discountAmount);
    }

    public Money calculatePercentDiscountedFee() {
        if (movieType != MovieType.PERCENT_DISCOUNT)
            throw new IllegalStateException();

        return fee.minus(fee.times(discountPercent));
    }

    public Money calculateNoneDiscountedFee() {
        if (movieType != MovieType.NONE_DISCOUNT)
            throw new IllegalStateException();

        return fee;
    }

    public boolean isDiscountable(LocalDateTime whenScreened, int sequence) {
        for(DiscountCondition discountCondition : discountConditions) {
            if(discountCondition.getDiscountConditionType() == DiscountConditionType.SEQUENCE){
                if(discountCondition.isDiscountable(sequence)){
                    return true;
                }
            } else {
                if(discountCondition.isDiscountable(whenScreened.getDayOfWeek(), whenScreened.toLocalTime())){
                    return true;
                }
            }
        }

        return false;
    }
}
