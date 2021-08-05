package com.kholofelo.springbootexample.sevice;

import com.kholofelo.springbootexample.entity.Student;
import com.kholofelo.springbootexample.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
      return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public void deleteStudentById(long id) {
     studentRepository.deleteById(id);
    }

    @Override
    public List<Student> getAllStudentsWithPagination(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1,pageSize);
        return studentRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Student> getAllStudentWithSorting() {
        Sort sort;
        sort = Sort.by(Sort.Direction.ASC,"firstName");
        return studentRepository.findAll(sort);
    }

    //like2query
    @Override
    public List<Student> findByFirstNameContains(String firstName) {
        return studentRepository.findByFirstNameContains(firstName);
    }

//    @Override
//    public List<Student> findByFirstNameStartWith(String firstName) {
//        return studentRepository.findByFirstNameStartWith(firstName);
//    }


}
