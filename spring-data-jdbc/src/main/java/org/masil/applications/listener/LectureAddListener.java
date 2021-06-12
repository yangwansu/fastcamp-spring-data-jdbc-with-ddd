package org.masil.applications.listener;

import org.masil.domains.lectures.CreateLecture;
import org.masil.domains.lectures.Lecture;
import org.masil.domains.lectures.LectureRepository;
import org.masil.domains.term.LectureAdded;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LectureAddListener {

    LectureRepository lectureRepository;

    @Async
    @EventListener
    public void on(LectureAdded anEvent) {
        CreateLecture command = CreateLecture.builder()
                .lectureId(anEvent.getLectureId())
                .termId(anEvent.getTermId())
                .name(anEvent.getName()).build();
        Lecture lecture = Lecture.create(command);
        lectureRepository.save(lecture);
    }
}
