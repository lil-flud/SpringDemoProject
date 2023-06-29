package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/*
When extending the REPOSITORY INTERFACE specify the T (the type of object we want this repository to work with)
and the ID for the type that we want.
 --JPARepository<Student, Long>--
 Student is the type of object we want to work with and Long is the datatype we are using for the ID in our
 Student class. We must also use @Repository on the interface declaration.
 */
@Repository
public interface StudentRepository
        extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
