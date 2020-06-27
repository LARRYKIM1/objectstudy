package com.larrykim.chap02.movice.pricing;

import com.larrykim.chap02.Money.Money;
import com.larrykim.chap02.movice.DiscountPolicy;
import com.larrykim.chap02.movice.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}