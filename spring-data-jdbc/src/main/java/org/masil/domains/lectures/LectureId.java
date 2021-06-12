package org.masil.domains.lectures;

import lombok.Value;

@Value(staticConstructor = "of")
public class LectureId {
    Long id;
}
