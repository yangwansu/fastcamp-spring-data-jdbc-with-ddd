package org.masil.domains.term;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

class TermIdTest {


    @Test
    void name() {

        TermId id = TermId.of(Year.of(2021), Qtr.Q1);

        assertThat(id.getValue()).isEqualTo(20211L);
    }
}