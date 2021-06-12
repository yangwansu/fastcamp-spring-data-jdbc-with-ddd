package org.masil.intrarastures.jdbc;

import org.masil.domains.lectures.Lecture;
import org.masil.domains.lectures.LectureId;
import org.masil.domains.lectures.LectureRepository;
import org.springframework.data.repository.Repository;

public interface DataJdbcLectureRepository extends LectureRepository, Repository<Lecture, LectureId> {
}
