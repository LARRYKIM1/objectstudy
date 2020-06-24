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
