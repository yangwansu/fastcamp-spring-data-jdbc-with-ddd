package org.masil.domains.regisgration;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.masil.domains.lecture.Lecture;
import org.masil.domains.lecture.LectureRepository;
import org.masil.domains.student.Student;
import org.masil.domains.student.StudentRepository;
import org.masil.domains.term.Term;
import org.masil.domains.term.TermRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class RegistrationRepositoryTest {


    @Autowired
    TermRepository termRepository;

    @Autowired
    LectureRepository lectureRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    RegistrationRepository registrationRepository;

    @Autowired
    EntityManager em;

    Term term;
    Long lectureID;
    Long studentID;

    @BeforeEach
    void setUp() {
        this.term = Term.of("2021.1");
        termRepository.save(term);

        Lecture aLecture = Lecture.create(term, "Spring Boot");
        lectureID = lectureRepository.save(aLecture).getId();

        Student aStudent = Student.of("Foo");
        studentID = studentRepository.save(aStudent).getId();

        // flush and remove l1 cache
        em.flush();
        em.clear();
    }


    @Test
    void save() {
        Optional<Lecture> find = lectureRepository.findById(lectureID);
        Optional<Student> find2 = studentRepository.findById(studentID);

        Lecture aLecture = find.orElse(null);
        Student aStudent =find2.orElse(null);

        Registration aRegistration = Registration.create(aStudent, aLecture);
        registrationRepository.save(aRegistration);

        assertThat(aLecture.getRegistrations()).hasSize(1);
        assertThat(aLecture.getRegistrations().get(0)).isSameAs(aRegistration);

        // flush and remove l1 cache
        em.flush();
        em.clear();

        registrationRepository.findById(aRegistration.getId());

    }
}