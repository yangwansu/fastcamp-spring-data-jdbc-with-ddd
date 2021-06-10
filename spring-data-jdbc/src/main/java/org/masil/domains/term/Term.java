package org.masil.domains.term;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE, onConstructor_=@PersistenceConstructor)
public class Term {

    public static Term of(String name) {
        return new Term(null, name);
    }

    @Id
    private TermId id;

    private String name;

}
