package org.masil.domains.term;

import lombok.Value;

@Value(staticConstructor = "of")
public class TermId {

    Long id;
}
