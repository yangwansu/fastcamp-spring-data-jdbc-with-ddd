package org.masil.domains.term;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;

class TermIdTest {


    @Test
    void create() {
        TermId id = TermId.create(Year.of(2021), Quarter.Q1);

        assertThat(id.getId()).isEqualTo(20211L);
        assertThat(id).isEqualTo(TermId.create(20211L));

        assertThat(id.toString()).isEqualTo("Term 2021-Q1");

    }
}