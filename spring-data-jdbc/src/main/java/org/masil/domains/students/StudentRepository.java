package org.masil.domains.students;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, StudentId> {
}
