package org.masil.domains.student;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.assertj.core.util.Lists;
import org.masil.domains.regisgration.Registration;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Collections;
import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

@Getter
@Entity
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED, force = true)
public class Student {

    public static Student of(String name) {
        return new Student(null, name, Lists.newArrayList());
    }

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "student")
    private List<Registration> registrations;

    public List<Registration> getRegistrations() {
        return Collections.unmodifiableList(registrations);
    }

    void add(Registration aRegistration) {
        this.registrations.add(aRegistration);
    }

    public static final class AddAdaptor {

        public static AddAdaptor of(Student aStudent) {
            return new AddAdaptor(aStudent);
        }

        private final Student student;

        private AddAdaptor(Student aStudent) {
            this.student = aStudent;
        }

        public void add(Registration aRegistration) {
            this.student.add(aRegistration);
        }
    }
}
