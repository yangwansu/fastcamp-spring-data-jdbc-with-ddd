package org.masil.domains.term;

import java.util.Arrays;

public enum Qtr {
    Q1(1),    Q2(2),    Q3(3), Q4(4);
    Qtr(int value) {
        this.value = value;
    }
    int value;

    public static Qtr of(int n) {
        return Arrays.stream(values()).filter(q->q.value==n).findFirst().orElse(null);
    }
}
