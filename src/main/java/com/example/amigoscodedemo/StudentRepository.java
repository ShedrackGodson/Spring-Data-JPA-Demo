package com.example.amigoscodedemo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);

    @Query("SELECT s FROM Student s WHERE s.firstName = ?1 AND s.age >= ?2")
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqual(String firstName, int age);

    @Query(
            nativeQuery = true,
            value = "SELECT * FROM Student WHERE first_name = :firstName AND age >= :age"
    ) // NativeQuery is a way to go
    List<Student> selectStudentWhereFirstNameAndAgeGreaterOrEqualNative(
            @Param("firstName") String firstName,
            @Param("age") int age
    );

    @Transactional
    @Modifying
    @Query(
            value = "DELETE FROM Student WHERE id = ?1",
            nativeQuery = true
    )
    int deleteStudentById(@Param("id") Long id); // returns 0 when no student found with the provided ID

}
