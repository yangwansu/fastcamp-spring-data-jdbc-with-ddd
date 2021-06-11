package org.masil.domains.term;

import lombok.Value;
import org.masil.domains.lecture.LectureId;

import java.time.Year;
import java.util.Set;

@Value
public class TermId {
    Long id;

    public static TermId create(Year year, Quarter q) {
        return new TermId(year.getValue() * 10L + q.value);
    }

    public static TermId create(Long id) {
        return create(year(id), quarter(id));
    }

    private static Quarter quarter(Long id) {
        return Quarter.of((int) (id % 10));
    }

    private static Year year(Long id) {
        return Year.of((int) (id / 10L));
    }

    @Deprecated
    public static TermId create(String name) {
        String[] splited = name.split("-");
        if(splited.length != 2) {
            throw new IllegalArgumentException();
        }

        return create(Year.of(Integer.parseInt(splited[0])), Quarter.of(Integer.parseInt(splited[1])));
    }

    @Override
    public String toString() {
        return String.format("Term %d-Q%d",year(id).getValue(), quarter(id).value);
    }

    public LectureId createALectureId(Set<TermLecture> lectures) {
        return LectureId.of((this.id *100)+lectures.size()+1);
    }
}
