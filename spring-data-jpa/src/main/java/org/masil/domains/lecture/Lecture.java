package org.masil.domains.lecture;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.assertj.core.util.Lists;
import org.masil.domains.regisgration.Registration;
import org.masil.domains.term.LectureAddAdaptor;
import org.masil.domains.term.Term;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Lecture {

    public static Lecture create(Term term, String title) {
        Lecture aLecture = new Lecture(null, term, title, Lists.newArrayList());
        LectureAddAdaptor.of(term).add(aLecture);
        return aLecture;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Term term;

    private String title;

    @OneToMany(mappedBy = "lecture")
    private List<Registration> registrations;

}
