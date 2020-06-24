package com.larrykim.chap02.movice.pricing;

import com.larrykim.chap02.Money.Money;
import com.larrykim.chap02.movice.DiscountCondition;
import com.larrykim.chap02.movice.DiscountPolicy;
import com.larrykim.chap02.movice.Screening;

public class PercentDiscountPolicy extends DiscountPolicy {
    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
