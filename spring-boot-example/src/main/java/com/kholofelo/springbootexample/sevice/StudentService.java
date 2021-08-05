package com.kholofelo.springbootexample.sevice;

import com.kholofelo.springbootexample.entity.Student;
import java.util.List;

public interface StudentService {

    List <Student> getAllStudent();
    Student saveStudent(Student student);
    Student getStudentById(long id);
    void deleteStudentById(long id);

    List<Student> getAllStudentsWithPagination(int pageNo, int pageSize);

    List<Student> getAllStudentWithSorting();

    List<Student> findByFirstNameContains(String firstName);

    //List<Student> findByFirstNameStartWith(String firstName);
}
