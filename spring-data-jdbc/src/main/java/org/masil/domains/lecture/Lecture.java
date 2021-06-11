package org.masil.domains.lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.masil.domains.term.Term;
import org.masil.domains.term.TermId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE, onConstructor_=@PersistenceConstructor)
public class Lecture {

    public static Lecture create(String name) {
        return new Lecture(null, name, AggregateReference.to(TermId.create(1L)));
    }

    @Id
    private LectureId id;

    private String name;

    private AggregateReference<Term, TermId> termId;
}
