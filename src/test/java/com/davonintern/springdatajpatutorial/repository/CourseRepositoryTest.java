package com.davonintern.springdatajpatutorial.repository;

import com.davonintern.springdatajpatutorial.entity.Course;
import com.davonintern.springdatajpatutorial.entity.Student;
import com.davonintern.springdatajpatutorial.entity.Teacher;
import net.bytebuddy.TypeCache;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CourseRepositoryTest {

    @Autowired CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course> courses=courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCoursewithTeacherObject(){

        Teacher teacher=Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();
        Course course=Course.builder()
                .courseTitle("python")
                .credit(6)
                .teacher(teacher)
                .build();
        courseRepository.save(course);

    }

    @Test
    public void findAllPagination(){
        Pageable firstPageWithThreeRecords=  PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords= (Pageable) PageRequest.of(1,2);
        List<Course> courses;
        courses = courseRepository.findAll((org.springframework.data.domain.Pageable) firstPageWithThreeRecords)
                .getContent();
        System.out.println(courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle=PageRequest.of(0,2,Sort.by("courseTitle"));

        Pageable sortByCreditDesc=PageRequest.of(0,2,Sort.by("credit").descending());

        List<Course> courses=courseRepository.findAll(sortByTitle).getContent();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithStudentAndTeachers(){
        Teacher teacher=Teacher.builder()
                .firstName("Lizze")
                .lastName("Morgan")
                .build();
        Student student=Student.builder()
                .firstName("sad")
                .lastName("sdad")
                .emailId("sdad")
                .build();
        Course course=Course.builder().courseTitle("AI").credit(4).teacher(teacher).build();
        course.addStudent(student);
        courseRepository.save(course);
    }


}