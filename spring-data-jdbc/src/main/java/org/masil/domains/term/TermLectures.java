package org.masil.domains.term;

import lombok.Value;
import org.masil.domains.lectures.Lecture;
import org.masil.domains.lectures.LectureId;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Value(staticConstructor = "of")
public class TermLectures {
    AggregateReference<Lecture, LectureId> lecture;
}
