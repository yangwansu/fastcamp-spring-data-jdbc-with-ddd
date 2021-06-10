package org.masil.domains.lecture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.masil.domains.term.Term;
import org.masil.domains.term.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
class LectureRepositoryTest {

    @Autowired
    TermRepository termRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    EntityManager em;

    Term term;
    Long lectureID;

    @BeforeEach
    void setUp() {
        this.term = Term.of("2021.1");
        termRepository.save(term);

        Lecture aLecture = Lecture.create(term, "Spring Boot");
        lectureID = lectureRepository.save(aLecture).getId();

        // flush and remove l1 cache
        em.flush();
        em.clear();
    }

    /**
     * @see #setUp()
     */
    @Test
    void find() {
        Optional<Lecture> find = lectureRepository.findById(lectureID);
        Lecture aLecture = find.orElse(null);

        assertThat(aLecture.getTerm().getId()).isEqualTo(term.getId());

        Lecture lazyLecture = aLecture.getTerm().getLectures().get(0);

        assertThat(lazyLecture.getId()).isEqualTo(aLecture.getId());
    }
}