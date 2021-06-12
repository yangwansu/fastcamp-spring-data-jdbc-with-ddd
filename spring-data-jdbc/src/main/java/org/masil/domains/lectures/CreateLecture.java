package org.masil.domains.lectures;

import lombok.Builder;
import lombok.Value;
import org.masil.domains.term.TermId;

@Value
@Builder
public class CreateLecture {
    LectureId lectureId;
    TermId termId;
    String name;
}
