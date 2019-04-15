package com.yule.sms2.service;

import com.yule.sms2.model.Student;

import java.util.List;

/**
 * Created by Yule.Paulusha on 4/12/2019.
 */
public interface StudentService {

    Student save(Student student);

    List<Student> fetch();

    Student fetch(Integer student);

    boolean delete(Integer student);
}