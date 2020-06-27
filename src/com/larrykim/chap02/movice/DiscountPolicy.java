package com.larrykim.chap02.movice;

import com.larrykim.chap02.Money.Money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
