package org.masil.domains.term;

import lombok.Value;
import org.masil.domains.lecture.Lecture;
import org.masil.domains.lecture.LectureId;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Value(staticConstructor = "of")
public class TermLecture {

    AggregateReference<Lecture, LectureId> lecture;

}
