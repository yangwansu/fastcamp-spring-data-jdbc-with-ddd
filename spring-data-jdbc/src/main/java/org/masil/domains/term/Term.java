package org.masil.domains.term;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.masil.domains.lecture.LectureId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor_=@PersistenceConstructor)
public class Term extends AbstractAggregateRoot<Term> {

    @Deprecated
    public static Term of(String name,int limitOfLectures) {
        TermId id = TermId.create(name);
        return new Term(id, null, id.toString(), limitOfLectures, new HashSet<>());
    }

    public static Term of(Year year, Quarter quarter, int limitOfLectures) {
        TermId id = TermId.create(year, quarter);
        return new Term(id, null, id.toString(), limitOfLectures, new HashSet<>());
    }

    @Id
    private TermId id;

    @Version
    private Long version;

    private String name;

    private int limitOfLectures;

    private Set<TermLecture> lectures;


    public Iterable<TermLecture> getLectures() {
        return lectures;
    }

    public void add(AddLecture aLecture) {
        if( this.lectures.size() >= limitOfLectures ) {
            throw new IllegalStateException("학기의 총 강의 수를 초가 할 수 없습니다.");
        }

        LectureId lectureId = this.id.createALectureId(this.lectures);

        this.lectures.add(TermLecture.of(AggregateReference.to(lectureId)));

        andEvent(new LectureAdded(lectureId, aLecture.getName()));
    }
}
