package com.example.redishashdemo.repository;

import com.example.redishashdemo.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, String> {
    Optional<List<Student>> findAllByGradeLevel(String gradeLevel);
}
