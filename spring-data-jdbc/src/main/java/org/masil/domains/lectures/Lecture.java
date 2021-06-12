package org.masil.domains.lectures;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masil.domains.regsitration.Registration;
import org.masil.domains.students.Student;
import org.masil.domains.term.TermId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.Version;

import java.util.HashSet;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE, onConstructor_=@PersistenceConstructor)
public class Lecture {

    public static Lecture create(CreateLecture command) {
        return new Lecture(command.getLectureId(), null,  command.getName(), command.getTermId(), new HashSet<>());
    }

    @Id
    private LectureId id;
    @Version
    private Long version;

    private final String name;
    private final TermId termId;

    private final Set<Registration> registrations;

    public void registrar(Student student) {
        Registration registration = Registration.of(id, student.getId());
        registrations.add(registration);
        student.registrar(registration);
    }
}
