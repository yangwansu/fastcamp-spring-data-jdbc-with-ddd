package org.masil.domains.students;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.masil.domains.regsitration.Registration;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;

import java.util.HashSet;
import java.util.Set;

import static lombok.AccessLevel.PRIVATE;

@Getter
@RequiredArgsConstructor(access = PRIVATE)
@AllArgsConstructor(access = PRIVATE, onConstructor_=@PersistenceConstructor)
public class Student {

    public static Student of(String name) {
        return new Student(null, name, new HashSet<>());
    }
    @Id
    private StudentId id;

    private String name;

    private final Set<Registration> registrations;

    public void registrar(Registration registration) {
        if(registration.getLecture() != null) {
            registrations.add(registration);
        }
    }
}
