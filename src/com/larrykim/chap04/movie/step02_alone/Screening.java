package com.larrykim.chap04.movie.step02_alone;

import com.larrykim.chap04.money.Money;

import java.time.LocalDateTime;

public class Screening { // 영화, 순번, 상영시간
    private Movie movie;
    private int sequence;
    private LocalDateTime whenScreened;

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    @Override
    public String toString() {
        return "{" +
                "영화=" + movie.toString() +
                ", 순번=" + sequence +
                ", 상영시간=" + whenScreened +
                '}';
    }

    public Money calculateFee(int audienceCount) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee().times(audienceCount);
                }
            case PERCENT_DISCOUNT:
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee().times(audienceCount);
                }
            case NONE_DISCOUNT:
                return movie.calculateNoneDiscountedFee().times(audienceCount);
        }

        return movie.calculateNoneDiscountedFee().times(audienceCount);
    }

}
