package org.masil.domains.lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE, onConstructor_=@PersistenceConstructor)
public class Lecture {

    public static Lecture create(String name) {
        return new Lecture(null, name);
    }

    @Id
    private LectureId id;

    private String name;
}
