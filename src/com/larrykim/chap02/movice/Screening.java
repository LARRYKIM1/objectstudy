package com.larrykim.chap02.movice;

import com.larrykim.chap02.Money.Money;

import java.time.LocalDateTime;

public class Screening {
    private Movie movie; //영화
    private int sequence; //몇번째 상영
    private LocalDateTime whenScreened; //상영시간

    public Screening(Movie movie, int sequence, LocalDateTime whenScreened) {
        this.movie = movie;
        this.sequence = sequence;
        this.whenScreened = whenScreened;
    }

    public LocalDateTime getStartTime() {
        return whenScreened;
    }

    public boolean isSequence(int sequence) {
        return this.sequence == sequence;
    }

    public Money getMovieFee() {
        return movie.getFee();
    }

    public Reservation reserve(Customer customer, int audienceCount) {
        // calculateFee, private 메서드를 호출
        System.out.println("Screeningd의 reserve 메서드 실행합니다.");
        return new Reservation(customer, this, calculateFee(audienceCount),
                audienceCount);
    }

    private Money calculateFee(int audienceCount) {
        System.out.println("Screeningd의 calculateFee 실행합니다.");
        return movie.calculateMovieFee(this).times(audienceCount);
    }
}
