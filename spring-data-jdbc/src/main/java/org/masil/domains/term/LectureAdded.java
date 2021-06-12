package org.masil.domains.term;

import lombok.Value;
import org.masil.domains.lectures.LectureId;

@Value
public class LectureAdded {

    public static LectureAdded create(AddLecture comnad, LectureId lectureId, TermId termId) {
        return new LectureAdded(comnad.getName(), lectureId, termId);
    }
    String name;
    LectureId lectureId;
    TermId termId;
}
