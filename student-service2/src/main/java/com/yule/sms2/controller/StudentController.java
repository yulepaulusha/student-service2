package com.yule.sms2.controller;

import com.sun.org.apache.regexp.internal.RE;
import com.yule.sms2.model.Course;
import com.yule.sms2.model.Student;
import com.yule.sms2.model.Telephone;
import com.yule.sms2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Created by Yule.Paulusha on 4/12/2019.
 */
@RestController
@RequestMapping(value = "smscloud")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public Student save(@RequestBody Student student){
        for(Telephone telephone:student.getTelephones()){
            telephone.setStudent(student);
        }
        return studentService.save(student);
    }

    @RequestMapping(value = "/student", method = RequestMethod.GET)
    public List<Student> fetch(){
        return studentService.fetch();
    }

    @RequestMapping(value = "student/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> fetch(@PathVariable Integer id){
        if(id<0){
            return ResponseEntity.badRequest().build();
        }
        else {
            Student student = studentService.fetch(id);
            if(student == null){
                return ResponseEntity.notFound().build();
            }
            else {
                return ResponseEntity.ok(student);
            }
        }
    }

    @RequestMapping(value = "/student/{id}/courses", method = RequestMethod.GET)
    public ResponseEntity<List<Course>> fetchCourse(@PathVariable Integer id){
        if(id<0){
            return ResponseEntity.badRequest().build();
        }
        else {
            Student student = studentService.fetch(id);
            if(student == null){
                return ResponseEntity.notFound().build();
            }
            else {
                return ResponseEntity.ok(student.getCourses());
            }
        }
    }

    @RequestMapping(value = "/student/{id}/telephone", method = RequestMethod.GET)
    public ResponseEntity<List<Telephone>> fetchTelephone(@PathVariable Integer id){
        if(id<0){
            return ResponseEntity.badRequest().build();
        }
        else {
            Student student = studentService.fetch(id);
            if(student == null){
                return ResponseEntity.notFound().build();
            }
            else {
                return ResponseEntity.ok(student.getTelephones());
            }
        }
    }

    @RequestMapping(value = "/student/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Integer id){
        return studentService.delete(id);
    }

//    @RequestMapping(value = "/student/{id}", method = RequestMethod.PUT)
//    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable Integer id){
//        if(id<0){
//            return ResponseEntity.badRequest().build();
//        }
//        else {
//            Student sid = studentService.fetch(id);
//            if(sid == null){
//                return ResponseEntity.notFound().build();
//            }
//            else {
//                student.setId(id);
//                student.setAddress(student.getAddress());
//                student.setCourses(student.getCourses());
//                studentService.save(student);
//                return ResponseEntity.ok(student);
//            }
//        }
//    }
}
