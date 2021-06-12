package org.masil.domains.students;

import lombok.Value;

@Value(staticConstructor = "of")
public class StudentId {
    Long id;
}
