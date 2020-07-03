package com.larrykim.chap04.movie.step02_alone;

import com.larrykim.chap04.money.Money;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Step02AloneMain {
    public static void main(String[] args) {
        List<Movie> movieList = generateMovie(); // 영화 3개 생성
        List<Screening> screeningList = generateScreening(movieList); // 영화 상영 정보 생성 각 3개씩 총 9개

//        Customer customer = new Customer("김유철", "id1234");

        List<Customer> customerList = generateCustomer();
        ReservationAgency reservationAgency = new ReservationAgency();
        for (int i = 0; i < 9; i++) {
            Reservation reservation = reservationAgency.reserve(screeningList.get(i), customerList.get(i), 2);

            // 0.1 할인비율로 적용된 소리꾼을 예약한 고객은 총금액이 18000원
            // 나머지는 800원이 할인되서 나온다. (살아있다, 온워드)
            System.out.printf("============= %d번째 예매 내역 ==============\n", i + 1);
            System.out.println(reservation.toString());
            System.out.println("==========================================");
        }

    }

    private static List<Customer> generateCustomer() {
        // 상영하는 영화 3개가 각 3번 9번 상영하므로, 한명당 한 영화 예약을 위해 9명 고객 생성
        List<Customer> customerList = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            Customer customer = new Customer("고객" + (i + 1), "id" + (i + 1));
            customerList.add(customer);
        }
        return customerList;
    }

    private static List<Screening> generateScreening(List<Movie> movieList) {
//        for (Movie movie : movieList) {
//            System.out.println(movie);
//        }

        LocalDateTime localDateTime = LocalDateTime.of(2020, 7, 6, 9, 10);

        List<Screening> screeningList = new ArrayList<>();

//        Screening screening1 = new Screening(movieList.get(0), 0, localDateTime);
//        screeningList.add(screening1);
//        Screening screening2 = new Screening(movieList.get(1), 1, localDateTime);
//        screeningList.add(screening2);
//        Screening screening3 = new Screening(movieList.get(2), 2, localDateTime);
//        screeningList.add(screening3);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // 모든 영화가 3번 상영 되도록 총 9개 생성
                Screening screening = new Screening(movieList.get(j), i + 1, localDateTime);
                screeningList.add(screening);
            }
        }

//        for (Screening screening : screeningList) {
//            Debug.println("상영정보 \n",screening.toString());
//        }

        return screeningList;
    }

    private static List<Movie> generateMovie() {
        // 1번째 영화에 할인 조건 추가 - SEQUENCE
        DiscountCondition discountConditionSequence = new DiscountCondition(1);
        // 월요일 아침 9시~12시 할인 조건 추가 - PERIOD
        DiscountCondition discountConditionPeriod = new DiscountCondition(DayOfWeek.MONDAY, LocalTime.of(9, 00), LocalTime.of(12, 00));

        List<Movie> movieList = new ArrayList<>();

        // 할인 조건 다른 3종류 영화 생성 - 모두 9:00~12:00 조조 할인과 1번째 영화 할인
        Movie movie1 = new Movie("살아있다", Duration.ofHours(2), Money.wons(10000), 800, discountConditionSequence, discountConditionPeriod);
        Movie movie2 = new Movie("소리꾼", Duration.ofHours(2), Money.wons(10000), 0.1, discountConditionSequence, discountConditionPeriod);
        Movie movie3 = new Movie("온워드", Duration.ofHours(2), Money.wons(10000), discountConditionSequence, discountConditionPeriod);

        movieList.add(movie1);
        movieList.add(movie2);
        movieList.add(movie3);

        return movieList;
    }
}
