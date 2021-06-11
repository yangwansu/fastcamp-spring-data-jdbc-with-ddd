package org.masil.domains.term;

import java.util.Arrays;

public enum Quarter {
    Q1(1),Q2(2),Q3(3),Q4(4);

    Quarter(int value) {
        this.value = value;
    }

    int value;

    public static Quarter of(Integer value) {
        return Arrays.stream(values()).filter(q->q.value == value).findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
