package com.davonintern.springdatajpatutorial.repository;

import com.davonintern.springdatajpatutorial.entity.Course;
import com.davonintern.springdatajpatutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){
        Course courseDBA2 =Course.builder()
                .courseTitle("DBA")
                .credit(5)
                .build();
        Course courseJAVA =Course.builder()
                .courseTitle("java")
                .credit(5)
                .build();
        Teacher teacher= Teacher.builder()
                .firstName("sdas")
                .lastName("sad")//
                // .courses(List.of(courseDBA2,courseJAVA))
                .build();
        teacherRepository.save(teacher);

    }


}