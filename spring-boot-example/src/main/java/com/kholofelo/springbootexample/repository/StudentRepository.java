package com.kholofelo.springbootexample.repository;

import com.kholofelo.springbootexample.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    List<Student> findByFirstNameContains(String firstName);

    //List<Student> findByFirstNameStartWith(String firstName);
}
