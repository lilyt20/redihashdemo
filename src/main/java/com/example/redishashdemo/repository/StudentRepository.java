package com.example.redishashdemo.repository;

import com.example.redishashdemo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    void deleteStudentsByGradeLevel(String gradeLevel);
}
