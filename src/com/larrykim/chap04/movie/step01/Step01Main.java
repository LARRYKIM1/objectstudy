package com.larrykim.chap04.movie.step01;

import com.larrykim.chap04.money.Money;

import java.time.Duration;

public class Step01Main {
    public static void main(String[] args) {
        Customer customer = new Customer("이름1", "아이디1");

        Screening screening = new Screening();
        Movie movie = new Movie("영화제목", Duration.ofHours(2), Money.wons(10000));
        screening.setMovie(movie);

        Reservation reservation = new Reservation(customer, screening, Money.wons(30000), 2);

        ReservationAgency reservationAgency = new ReservationAgency();
        reservationAgency.reserve(screening, customer, 2);



    }
}
