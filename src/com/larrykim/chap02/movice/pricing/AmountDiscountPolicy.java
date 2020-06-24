package com.larrykim.chap02.movice.pricing;

import com.larrykim.chap02.Money.Money;
import com.larrykim.chap02.movice.DiscountCondition;
import com.larrykim.chap02.movice.DiscountPolicy;
import com.larrykim.chap02.movice.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}