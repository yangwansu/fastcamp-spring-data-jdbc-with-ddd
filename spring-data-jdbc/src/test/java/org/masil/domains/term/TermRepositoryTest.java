package org.masil.domains.term;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class TermRepositoryTest {


    @Autowired
    TermRepository termRepository;


    @Test
    void saveAndFind() {
        Term aTerm = Term.of("2021-1", 10);

        Term saved = termRepository.save(aTerm);

        assertThat(saved.getId()).isNotNull();

        Term find = termRepository.findById(saved.getId());

        assertThat(find.getId()).isEqualTo(saved.getId());

        termRepository.save(aTerm);
    }

    @Test
    void addLecture() {
        Term aTerm = Term.of("2021-1", 1);
        aTerm.add(AddLecture.create("Spring boot"));

        Term saved = termRepository.save(aTerm);

        Term find = termRepository.findById(saved.getId());

        assertThat(find.getLectures()).hasSize(1);
    }
}