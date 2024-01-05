package com.ankit.crudapplication.repository;

import com.ankit.crudapplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query(value = "SELECT * FROM student WHERE id = ?1", nativeQuery = true)
    Student getStudentById(int rollNumber);
}
