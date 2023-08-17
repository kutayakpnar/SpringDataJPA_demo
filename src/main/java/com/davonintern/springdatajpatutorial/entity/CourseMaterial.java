package com.davonintern.springdatajpatutorial.entity;


import jakarta.persistence.*;
import lombok.*;
import com.davonintern.springdatajpatutorial.entity.Course;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name="course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence")
    private Long courseMaterialId;
    private String url;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch=FetchType.LAZY
    )
    @JoinColumn(
            name="course_Id",
            referencedColumnName = "courseId"
    )
    private Course course;


}
