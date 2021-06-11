package org.masil.domains.term;

import lombok.Value;


@Value(staticConstructor = "create")
public class NewLecture {
    String name;
}
