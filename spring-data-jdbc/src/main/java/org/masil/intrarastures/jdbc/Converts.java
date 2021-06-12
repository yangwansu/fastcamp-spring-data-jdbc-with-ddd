package org.masil.intrarastures.jdbc;

import org.masil.domains.lectures.Lecture;
import org.masil.domains.lectures.LectureId;
import org.masil.domains.students.StudentId;
import org.masil.domains.term.Term;
import org.masil.domains.term.TermId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;

public final class Converts {

    @WritingConverter
    public enum LectureIdToLong implements Converter<LectureId, Long> {
        INSTANCE;
        @Override
        public Long convert(LectureId source) {
            return source.getId();
        }
    }

    @ReadingConverter
    public enum LongToLectureId implements Converter<Long,LectureId> {
        INSTANCE;
        @Override
        public LectureId convert(Long source) {
            return LectureId.of(source);
        }
    }

    @WritingConverter
    public enum TermIdToLong implements Converter<TermId, Long> {
        INSTANCE;
        @Override
        public Long convert(TermId source) {
            return source.getId();
        }
    }

    @ReadingConverter
    public enum LongToTermId implements Converter<Long,TermId> {
        INSTANCE;
        @Override
        public TermId convert(Long source) {
            return TermId.of(source);
        }
    }

    @WritingConverter
    public enum StudentIdToLong implements Converter<StudentId, Long> {
        INSTANCE;
        @Override
        public Long convert(StudentId source) {
            return source.getId();
        }
    }

    @ReadingConverter
    public enum LongToStudentId implements Converter<Long,StudentId> {
        INSTANCE;
        @Override
        public StudentId convert(Long source) {
            return StudentId.of(source);
        }
    }



}
