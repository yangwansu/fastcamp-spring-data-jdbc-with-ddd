package org.masil.domains.term;

import lombok.Value;

@Value(staticConstructor = "of")
public class AddLecture {

    String name;
}
