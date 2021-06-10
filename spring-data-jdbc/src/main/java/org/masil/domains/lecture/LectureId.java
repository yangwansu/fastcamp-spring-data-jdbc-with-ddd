package org.masil.domains.lecture;

import lombok.Value;

@Value(staticConstructor = "of")
public class LectureId {
    Long id;
}
