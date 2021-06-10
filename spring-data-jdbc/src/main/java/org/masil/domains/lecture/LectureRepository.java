package org.masil.domains.lecture;

public interface LectureRepository {
    Lecture save(Lecture aLecture);

    Lecture findById(LectureId id);
}
