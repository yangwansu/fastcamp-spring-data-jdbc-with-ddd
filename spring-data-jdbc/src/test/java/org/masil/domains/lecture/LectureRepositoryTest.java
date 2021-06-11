package org.masil.domains.lecture;

import org.junit.jupiter.api.Test;
import org.masil.domains.term.Quarter;
import org.masil.domains.term.TermId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.time.Year;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@SpringBootTest
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class LectureRepositoryTest {

    @Autowired
    LectureRepository lectureRepository;


    @Test
    void saveAndFind() {
        Lecture aLecture = Lecture.create(LectureId.of(2021101L), "Spring boot", TermId.create(Year.of(2021), Quarter.Q1));

        Lecture saved = lectureRepository.save(aLecture);

        assertThat(saved.getId()).isNotNull();

        Lecture find = lectureRepository.findById(saved.getId());

        assertThat(find.getId()).isEqualTo(saved.getId());
    }

}