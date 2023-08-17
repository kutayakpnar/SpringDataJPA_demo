package com.davonintern.springdatajpatutorial.repository;

import com.davonintern.springdatajpatutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

     List<Student> findByFirstName(String firstName);

     List<Student> findByFirstNameContaining(String name);

    List<Student> findByGuardianName(String guardianName);

    //Jpql ?1 means equals the first parameter
    @Query("select s from Student s where s.emailId=?1")
    Student getStudentByEmailAddress(String emailId);

    //Jpql
    @Query("select s.firstName from Student s where s.emailId=?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //NativeQuery
    @Query(
            value = "SELECT * FROM tbl_Student s where s.email_address=?1",
            nativeQuery = true

    )
    Student getStudentByEmailAddressNative(String emailId);

    //Native named param
    @Query(
            value = "SELECT * FROM tbl_Student s where s.email_address=:emailId",
            nativeQuery = true

    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying //If we update and delete data we have to use that
    @Transactional //You can use in service layer
    @Query(
            value="update tbl_student set first_name=?1 where email_address=?2",
            nativeQuery=true
    )
    int updateStudentNameByEmailId(String firstName,String emailId);



}
