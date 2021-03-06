package org.masil.domains.regisgration;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.masil.domains.lecture.Lecture;
import org.masil.domains.student.Student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Entity
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Registration {

    public static Registration create(Student student, Lecture lecture) {
        Registration newRegistration = new Registration(null, student, lecture);
        Lecture.AddAdaptor.of(lecture).add(newRegistration);
        Student.AddAdaptor.of(student).add(newRegistration);
        return newRegistration;
    }

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Lecture lecture;

}
