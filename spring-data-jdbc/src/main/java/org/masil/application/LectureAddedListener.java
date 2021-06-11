package org.masil.application;

import org.masil.domains.lecture.Lecture;
import org.masil.domains.lecture.LectureRepository;
import org.masil.domains.term.LectureAdded;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LectureAddedListener {

    final LectureRepository lectureRepository;

    public LectureAddedListener(LectureRepository lectureRepository) {
        this.lectureRepository = lectureRepository;
    }

    @Async
    @EventListener(classes = LectureAdded.class)
    public void on(LectureAdded event) {
        Lecture aLecture = Lecture.create(event.getLectureId(), event.getName(), event.getTermId());
        lectureRepository.save(aLecture);
    }
}
