package org.masil.domains.lectures;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.masil.domains.regsitration.Registration;
import org.masil.domains.students.Student;
import org.masil.domains.students.StudentRepository;
import org.masil.domains.term.Qtr;
import org.masil.domains.term.TermId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Year;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class LectureRepositoryTest {


    @Autowired
    LectureRepository repository;

    @Autowired
    StudentRepository studentRepository;

    @Test
    void saveAndFind() {
        TermId termId = TermId.of(Year.of(2021), Qtr.Q1);
        LectureId lectureId = termId.createLectureId(1);
        CreateLecture command = CreateLecture.builder()
                .lectureId(lectureId)
                .termId(termId)
                .name("Spring Data JDBC").build();

        Lecture aLecture = Lecture.create(command);

        Lecture saved = repository.save(aLecture);

        assertThat(saved).isSameAs(aLecture);

        assertThat(saved.getId()).isNotNull();

        Lecture find = repository.findById(saved.getId());

        assertThat(find).isNotSameAs(aLecture);

        assertThat(find.getName()).isEqualTo(aLecture.getName());

    }

    @Test
    void registra() {
        TermId termId = TermId.of(Year.of(2021), Qtr.Q1);
        LectureId lectureId = termId.createLectureId(1);
        CreateLecture command = CreateLecture.builder()
                .lectureId(lectureId)
                .termId(termId)
                .name("Spring Data JDBC").build();

        Lecture aLecture = Lecture.create(command);

        Lecture saved = repository.save(aLecture);

        Student masil = Student.of("Masil");
        studentRepository.save(masil);

        saved.registrar(masil);

        repository.save(saved);

        Lecture find = repository.findById(saved.getId());

        assertThat(find.getRegistrations().contains(Registration.of(find.getId(), masil.getId()))).isTrue();

        Student findMasil = studentRepository.findById(masil.getId()).orElse(null);

        assertThat(findMasil.getRegistrations().contains(Registration.of(find.getId(), masil.getId()))).isTrue();
    }
}