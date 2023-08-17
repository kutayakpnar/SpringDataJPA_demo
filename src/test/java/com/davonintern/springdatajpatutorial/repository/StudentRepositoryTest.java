package com.davonintern.springdatajpatutorial.repository;

import com.davonintern.springdatajpatutorial.entity.Guardian;
import com.davonintern.springdatajpatutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.desktop.SystemEventListener;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest //Help test the repository layer when test is completed,it flush the data.So database is not impacted.
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent(){
        Student student = Student.builder().emailId("x@gmail.com").firstName("x").lastName("y")
               // .guardianName("z").
               // guardianEmail("z@gmail.com").
                //guardianMobile("123")
                .build();

        studentRepository.save(student);
    }
    @Test
    public void saveStudentWithGuardian(){
        Guardian guardian=Guardian.builder()
                .name("sad")
                .email("daad@gmail.com")
                .mobile("12321")
                .build();
        Student student=Student.builder()
                .firstName("kk")
                .emailId("asdd@gmail.com")
                .lastName("sgsg")
                .guardian(guardian)
                .build();

        studentRepository.save(student);

    }


    @Test
    public void printAllStudent(){
        List<Student> studentList=studentRepository.findAll();
        System.out.println("studentList="+studentList);
    }

    @Test
    public void printStudentsByFirstName(){
        List<Student> students=studentRepository.findByFirstName("kk");
        System.out.println("studentList="+students);

    }

    @Test
    public void printStudentsByFirstNameContaining(){
        List<Student> students=studentRepository.findByFirstNameContaining("k");
        System.out.println("studentList="+students);

    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students=studentRepository.findByGuardianName("sad");
        System.out.println("studentList="+students);

    }
    @Test
    public void printGetStudentByEmailAddress(){
        Student student=studentRepository.getStudentByEmailAddress("x@gmail.com");
        System.out.println(student);
    }
    @Test
    public void printStudentsFirstNameByEmailAddress(){
        String firstName=studentRepository.getStudentFirstNameByEmailAddress("x@gmail.com");
        System.out.println("firstName="+firstName);
    }

    @Test
    public void printStudentsByEmailAddressNative() {
        Student student = studentRepository.getStudentByEmailAddressNative("x@gmail.com");
        System.out.println("Student=" + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("x@gmail.com");
        System.out.println("Student=" + student);

    }

    @Test
    public void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId("ahmet","x@gmail.com");

    }





}