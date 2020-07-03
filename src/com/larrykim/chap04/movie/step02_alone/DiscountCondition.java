package com.larrykim.chap04.movie.step02_alone;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition { //타입, 순번, 요일, 시작 시간, 종료 시간
    private DiscountConditionType discountConditionType;
    private int sequence;
    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountCondition(int sequence){
        this.discountConditionType = DiscountConditionType.SEQUENCE;
        this.sequence = sequence;
    }

    public DiscountCondition(DayOfWeek dayOfWeek, LocalTime startTime, LocalTime endTime){
        this.discountConditionType = DiscountConditionType.PERIOD;
        this.dayOfWeek= dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public DiscountConditionType getDiscountConditionType() {
        return discountConditionType;
    }

    public boolean isDiscountable(DayOfWeek dayOfWeek, LocalTime time){
        if (discountConditionType != DiscountConditionType.PERIOD) {
            throw new IllegalArgumentException();
        }
        // 책방식
        return this.dayOfWeek.equals(dayOfWeek) &&
                this.startTime.compareTo(time) <= 0 &&
                this.endTime.compareTo(time) >= 0;

        // TODO 나중에 실행 해보기
        // 내방식
//        return this.dayOfWeek == dayOfWeek && time.isBefore(endTime) && time.isAfter(startTime);
    }
    public boolean isDiscountable(int sequence){
        return this.sequence == sequence;
    }

    @Override
    public String toString() {
        return "{" +
                "적용된 할인 조건=" + discountConditionType +
                '}';
    }
}
