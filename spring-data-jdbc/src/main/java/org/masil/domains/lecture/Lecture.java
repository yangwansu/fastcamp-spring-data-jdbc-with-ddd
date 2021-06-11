package org.masil.domains.lecture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.masil.domains.term.Term;
import org.masil.domains.term.TermId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import static lombok.AccessLevel.PRIVATE;

@Getter
@AllArgsConstructor(access = PRIVATE, onConstructor_=@PersistenceConstructor)
public class Lecture {

    public static Lecture create(LectureId lectureId, String name, TermId termId) {
        return new Lecture(lectureId, null, name, AggregateReference.to(termId));
    }

    @Id
    private LectureId id;

    @Version
    private Long version;

    private String name;

    private AggregateReference<Term, TermId> termId;

    public TermId getTermIdaa() {
        return termId.getId();
    }
}
