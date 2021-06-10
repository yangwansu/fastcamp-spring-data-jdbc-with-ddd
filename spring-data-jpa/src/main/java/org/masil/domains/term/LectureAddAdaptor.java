package org.masil.domains.term;

import org.masil.domains.lecture.Lecture;

public final class LectureAddAdaptor{

    public static LectureAddAdaptor of(Term aTerm) {
        return new LectureAddAdaptor(aTerm);
    }

    private final Term term;

    private LectureAddAdaptor(Term term) {
        this.term = term;
    }

    public void add(Lecture aLecture) {
        this.term.addLecture(aLecture);
    }
}
