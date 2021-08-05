package com.kholofelo.springbootexample.controller;

import com.kholofelo.springbootexample.entity.Student;
import com.kholofelo.springbootexample.sevice.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public Student saveEmployee(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentService.getAllStudent();
    }

    // get student by id rest api
    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Long id) {
        Student student;
        student = studentService.getStudentById(id);
        return student;
    }

    @GetMapping("/getAllWithPagination")
    public List<Student> getAllStudentsWithPagination(@RequestParam int pageNo,@RequestParam int pageSize){

        List<Student> studentList;
        studentList = studentService.
                getAllStudentsWithPagination(pageNo,pageSize);
        return studentList;
    }

    //Sorting
    @GetMapping("/getAllWthSorting")
    public List<Student> getAllStudentWithSorting(){

        List<Student> studentList;
        studentList = studentService.getAllStudentWithSorting();
        return studentList;
    }

    @GetMapping("/like/{firstName}")
    public List<Student> like(@PathVariable String firstName){

        return studentService.findByFirstNameContains(firstName);
    }

//    @GetMapping("/startWith/{firstName}")
//    public List<Student> startWith(@PathVariable String firstName){
//       return studentService.findByFirstNameStartWith(firstName);
//    }
}
