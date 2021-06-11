package org.masil.application;

import org.masil.domains.term.LectureAdded;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LectureAddedListener {


    @Async
    @EventListener(classes = LectureAdded.class)
    public void on(LectureAdded event) {
        System.out.println(event);
        throw new IllegalStateException();
    }
}
