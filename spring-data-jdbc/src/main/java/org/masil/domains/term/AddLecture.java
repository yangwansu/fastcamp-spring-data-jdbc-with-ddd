package org.masil.domains.term;

import lombok.Value;


@Value(staticConstructor = "create")
public class AddLecture {
    String name;
}
