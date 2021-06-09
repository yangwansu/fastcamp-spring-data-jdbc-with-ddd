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
    Long lectureID;

    @Autowired
    EntityManager em;

    @BeforeEach
    void setUp() {
        Term aTerm = Term.of("2021.1");
        termRepository.save(aTerm);
        System.out.println("aTerm" + aTerm);

        Lecture aLecture = Lecture.create(aTerm, "Spring Boot");

        System.out.println("aLecture" + aLecture);

        lectureID = lectureRepository.save(aLecture).getId();

        em.flush();
    }

    @Test
    void save() {
        Iterable<Lecture> all = lectureRepository.findAll();
        Optional<Lecture> find = lectureRepository.findById(lectureID);
        Lecture aLecture = find.orElse(null);
        System.out.println("aTerm" + aLecture.getTerm());
        System.out.println("aLecture" + aLecture);
        //assertThat(aLecture.getTerm().getLectures().get(0)).isNotNull();
    }
}