package org.masil.infrastructure.repositories;

import org.masil.domains.term.Term;
import org.masil.domains.term.TermId;
import org.masil.domains.term.TermRepository;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.convert.WritingConverter;
import org.springframework.data.repository.Repository;

public interface DataJdbcTermRepository extends Repository<Term, TermId> , TermRepository {


    @WritingConverter
    enum TermIdToLong implements Converter<TermId, Long> {
        INSTANCE;

        @Override
        public Long convert(TermId source) {
            return source.getId();
        }
    }

    @ReadingConverter
    enum LongToTermId implements Converter<Long, TermId> {
        INSTANCE;

        @Override
        public TermId convert(Long source) {
            return TermId.of(source);
        }
    }
}
