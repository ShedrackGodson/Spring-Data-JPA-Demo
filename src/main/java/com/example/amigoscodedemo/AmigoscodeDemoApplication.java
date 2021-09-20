package com.example.amigoscodedemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

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


            System.out.println("Delete Seth_2");
//            studentRepository.deleteById(3L);

        };
    }

}
