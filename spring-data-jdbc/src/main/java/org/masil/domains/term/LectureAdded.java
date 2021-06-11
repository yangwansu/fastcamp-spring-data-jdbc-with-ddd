package org.masil.domains.term;

import lombok.Value;
import org.masil.domains.lecture.LectureId;

@Value
public class LectureAdded {

    LectureId lectureId;
    String name;
}
