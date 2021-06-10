package org.masil.infrastructure.repositories;

import org.masil.domains.lecture.Lecture;
import org.masil.domains.lecture.LectureId;
import org.masil.domains.lecture.LectureRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.repository.Repository;

public interface DataJdbcLectureRepository extends Repository<Lecture, LectureId> , LectureRepository {


    @WritingConverter
    enum LectureIdToLong implements Converter<LectureId, Long> {
        INSTANCE;

        @Override
        public Long convert(LectureId source) {
            return source.getId();
        }
    }

    @ReadingConverter
    enum LongToLectureId implements Converter<Long, LectureId> {
        INSTANCE;

        @Override
        public LectureId convert(Long source) {
            return LectureId.of(source);
        }
    }
}
