package org.masil.domains.term;


import org.junit.jupiter.api.Test;
import org.masil.domains.lecture.LectureId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.ApplicationEvents;
import org.springframework.test.context.event.RecordApplicationEvents;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@RecordApplicationEvents
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class LectureAddedPublishTest {

    @Autowired
    TermRepository termRepository;

    @Autowired
    ApplicationEvents applicationEvents;


    @Test
    void saveAndPublish() {
        Term aTerm = Term.of("2021-1", 1);
        aTerm.add(AddLecture.create("Spring boot"));

        termRepository.save(aTerm);

        LectureId id = aTerm.getLectures().iterator().next().getLecture().getId();

        assertThat(applicationEvents.stream(LectureAdded.class))
                .containsExactly(new LectureAdded(id, "Spring boot"));
        //verify(context).publishEvent(any(NewLectureAdded.class));
    }
}
