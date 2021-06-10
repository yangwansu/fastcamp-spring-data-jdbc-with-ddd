package org.masil.domains.term;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TermRepositoryTest {


    @Autowired
    TermRepository termRepository;


    @Test
    void saveAndFind() {
        Term aTerm = Term.of("2021-1");

        Term saved = termRepository.save(aTerm);

        assertThat(saved.getId()).isNotNull();

        Term find = termRepository.findById(saved.getId());

        assertThat(find.getId()).isEqualTo(saved.getId());

    }
}