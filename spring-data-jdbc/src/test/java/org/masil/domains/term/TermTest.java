package org.masil.domains.term;

import org.junit.jupiter.api.Test;
import org.masil.domains.lecture.LectureId;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TermTest {


    @Test
    void limit_Of_Lecture_on_term() {
        Term aTerm = Term.of("2021-1", 1);
        aTerm.add(AddLecture.create("SPRING MVC"));

        assertThatThrownBy(()->aTerm.add(AddLecture.create("SPRING BOOT")))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("학기의 총 강의 수를 초가 할 수 없습니다.");
    }


    @Test
    void lectureId_made_by_termid() {
        Term aTerm = Term.of(Year.of(2021), Quarter.Q1,  1);
        aTerm.add(AddLecture.create("SPRING MVC"));

        TermLecture map = aTerm.getLectures().iterator().next();

        assertThat(map.getLecture().getId()).isEqualTo(LectureId.of(2021101L));
    }
}
