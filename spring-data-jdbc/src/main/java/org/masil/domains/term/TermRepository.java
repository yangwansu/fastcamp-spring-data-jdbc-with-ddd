package org.masil.domains.term;

public interface TermRepository {

    Term save(Term aTerm);

    Term findById(TermId id);
}
