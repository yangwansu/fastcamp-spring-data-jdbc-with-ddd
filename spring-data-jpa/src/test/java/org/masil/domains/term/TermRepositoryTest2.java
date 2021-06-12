package org.masil.domains.term;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.masil.domains.lecture.LectureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
class TermRepositoryTest2 {

    @Autowired
    TermRepository termRepository;

    @BeforeEach
    void setUp() {
        Term aTerm = Term.of("2021.1");
        termRepository.save(aTerm);
    }

    @Test
    void save() {

        Iterable<Term> all = termRepository.findAll();


    }
}