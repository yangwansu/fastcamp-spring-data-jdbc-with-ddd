package org.masil.domains.lecture;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.annotation.DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD;

@SpringBootTest
@DirtiesContext(classMode = BEFORE_EACH_TEST_METHOD)
class LectureRepositoryTest {

    @Autowired
    LectureRepository lectureRepository;


    @Test
    void saveAndFind() {
        Lecture aLecture = Lecture.create("Spring boot");

        Lecture saved = lectureRepository.save(aLecture);

        assertThat(saved.getId()).isNotNull();

        Lecture find = lectureRepository.findById(saved.getId());

        assertThat(find.getId()).isEqualTo(saved.getId());
    }

}