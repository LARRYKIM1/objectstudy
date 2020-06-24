package com.larrykim.chap02.movice.pricing;

import com.larrykim.chap02.movice.DiscountCondition;
import com.larrykim.chap02.movice.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }

}