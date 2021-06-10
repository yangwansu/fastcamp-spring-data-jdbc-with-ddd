package org.masil.domains.term;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.assertj.core.util.Lists;
import org.masil.domains.lecture.Lecture;

import javax.persistence.*;

import java.util.Collections;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED, force = true)
public class Term {

    public static Term of(String name) {
        return new Term(null, name, Lists.newArrayList());
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "term")
    private List<Lecture> lectures;

    public List<Lecture> getLectures() {
        return Collections.unmodifiableList(lectures);
    }

    void addLecture(Lecture aLecture) {
        lectures.add(aLecture);
    }

}
