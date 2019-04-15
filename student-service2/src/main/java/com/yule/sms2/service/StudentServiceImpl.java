package com.yule.sms2.service;

import com.yule.sms2.model.Student;
import com.yule.sms2.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Yule.Paulusha on 4/12/2019.
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetch() {
        return studentRepository.findAll();
    }

    @Override
    public Student fetch(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        if(student.isPresent()){
            return student.get();
        } else {
            return null;
        }
    }

    @Override
    public boolean delete(Integer id) {
        studentRepository.deleteById(id);
        return true;
    }
}
