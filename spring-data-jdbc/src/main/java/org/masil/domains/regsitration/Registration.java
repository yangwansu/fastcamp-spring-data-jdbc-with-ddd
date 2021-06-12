package org.masil.domains.regsitration;

import lombok.Value;
import org.masil.domains.lectures.Lecture;
import org.masil.domains.lectures.LectureId;
import org.masil.domains.students.Student;
import org.masil.domains.students.StudentId;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@Value
public class Registration {

    public static Registration of(LectureId lectureId, StudentId studentId) {
        return new Registration(AggregateReference.to(lectureId), AggregateReference.to(studentId));
    }
    AggregateReference<Lecture, LectureId> lecture;
    AggregateReference<Student, StudentId> student;
}
