package org.masil.domains.term;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TermTest {


    @Test
    void 학기의_최대_개설_강의_수를_넘었습니다() {

        Term aTerm = Term.of("2021-1", 1);
        aTerm.add(AddLecture.of("Spring Data Jdbc"));

        assertThatThrownBy(()->aTerm.add(AddLecture.of("Spring Data Jdbc")))
            .isInstanceOf(IllegalStateException.class)
            .hasMessage("학기의 최대 개설 강의 수를 넘었습니다.");

    }
}
