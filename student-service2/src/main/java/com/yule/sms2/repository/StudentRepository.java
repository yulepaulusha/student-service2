package com.yule.sms2.repository;

import com.yule.sms2.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Yule.Paulusha on 4/12/2019.
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {
}
