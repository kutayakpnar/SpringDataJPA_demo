package com.davonintern.springdatajpatutorial.repository;

import com.davonintern.springdatajpatutorial.entity.Course;
import com.davonintern.springdatajpatutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){
        Course course= Course.builder()
                .courseTitle("DSA")
                .credit(6)
                .build();
        CourseMaterial courseMaterial=CourseMaterial.builder()
                .url("adsda")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);

    }

    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterials=courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }


}