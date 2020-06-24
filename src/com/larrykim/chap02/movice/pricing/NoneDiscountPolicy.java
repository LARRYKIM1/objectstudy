package com.larrykim.chap02.movice.pricing;

import com.larrykim.chap02.Money.Money;
import com.larrykim.chap02.movice.DiscountPolicy;
import com.larrykim.chap02.movice.Screening;

public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}