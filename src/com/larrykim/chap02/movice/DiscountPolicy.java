package com.larrykim.chap02.movice;

import com.larrykim.chap02.Money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class DiscountPolicy {
    private List<DiscountCondition> conditions = new ArrayList<>();

    public DiscountPolicy(DiscountCondition ... conditions) {
        this.conditions = Arrays.asList(conditions);
    }

    public Money calculateDiscountAmount(Screening screening) {
        System.out.println("해당 상영이 할인 조건에 해당하는지 체크하는 중입니다.");
        // 문제점: 할인 정책이 없는 경우 NoneDiscountPolicy를 정책으로 사용하고 있지만,
        // 할인율이 없지만 getDiscontAmount()를 통해 할인율 함수를 호출하고 있음
        for(DiscountCondition each : conditions) {
            if (each.isSatisfiedBy(screening)) {
                System.out.println("할인조건에 해당되네요.");
                return getDiscountAmount(screening);
            }
        }
        System.out.println("할인조건에 해당이 안되네요.");
        return Money.ZERO;
    }

    abstract protected Money getDiscountAmount(Screening Screening);

}
