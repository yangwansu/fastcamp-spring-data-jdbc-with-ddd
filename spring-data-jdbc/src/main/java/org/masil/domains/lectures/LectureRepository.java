package org.masil.domains.lectures;

public interface LectureRepository {

    Lecture save(Lecture aLecture);

    Lecture findById(LectureId id);
}
