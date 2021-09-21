package com.example.amigoscodedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class AmigoscodeDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmigoscodeDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
          Student seth = new Student(
                  "Seth",
                  "Godson",
                  "seth_2@company.go",
                  18
          );
//          studentRepository.save(seth);

            Student abed = new Student(
                    "Abed",
                    "Godson",
                    "abed@company.go",
                    21
            );

            Student tabitha = new Student(
                    "Tabitha",
                    "Godson",
                    "tabitha@company.go",
                    26
            );

//            System.out.println("Adding students");
//            studentRepository.save(seth);
//            studentRepository.save(abed);
//            studentRepository.save(tabitha);

            System.out.println("Counting students \n" + studentRepository.count());

            System.out.println("Select all students");
            List<Student> students = studentRepository.findAll();
            students.forEach(System.out::println);


            System.out.println("Find Student by Email");

            Optional<Student> student = studentRepository.findStudentByEmail("abed@company.go");
            if(student.isPresent()){
                System.out.println(student);
            } else {
                System.out.println("Student with that email address does not exists.");
            }

            System.out.println("Filtering Students");
            List<Student> studentsByFirstNamesAndAges = studentRepository.selectStudentWhereFirstNameAndAgeGreaterOrEqual(
                    "Seth", 18
            );
            System.out.println(studentsByFirstNamesAndAges);

            System.out.println("Filtering Students Using Native Query");
            List<Student> studentsByFirstNamesAndAgesNative = studentRepository.selectStudentWhereFirstNameAndAgeGreaterOrEqualNative(
                    "Tabitha", 18
            );
            System.out.println(studentsByFirstNamesAndAgesNative);

            System.out.println("Delete Student by ID using Native Query");
            System.out.println("Deleted student with an ID of " + studentRepository.deleteStudentById(1L));

        };
    }

}
