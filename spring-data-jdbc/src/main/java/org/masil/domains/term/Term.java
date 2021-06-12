package org.masil.domains.term;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masil.domains.lectures.LectureId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Version;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

import java.time.Year;
import java.util.HashSet;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE, onConstructor_ = @PersistenceConstructor)
public class Term extends AbstractAggregateRoot<Term> {

    @Deprecated
    public static Term of(String name) {
        return new Term(TermId.of(name), null,  name, 10, new HashSet<>());
    }

    @Deprecated
    public static Term of(String name, int limitOfLecture) {
        return new Term(TermId.of(name), null, name, limitOfLecture, new HashSet<>());
    }

    public static Term of(Year year, Qtr qtr, int limitOfLecture) {
        TermId termId = TermId.of(year, qtr);
        return new Term(termId, null, termId.toString(), limitOfLecture, new HashSet<>());
    }

    @Id
    private TermId id;
    @Version
    private Long version;
    private String name;
    private int limitOfLecture;

    private Set<TermLectures> lectures;

    public void add(AddLecture command) {
        if (lectures.size() == limitOfLecture) {
            throw new IllegalStateException("학기의 최대 개설 강의 수를 넘었습니다.");
        }
        LectureId aLectureID = id.createLectureId(lectures.size());
        lectures.add(TermLectures.of(AggregateReference.to(aLectureID)));

        andEvent(LectureAdded.create(command, aLectureID, id));
    }

}
