package com.ankit.crudapplication.service;

import com.ankit.crudapplication.dto.StudentDto;
import java.util.List;

public interface StudentService {

    // Create
    String addStudent(StudentDto studentDto);

    // Read
    List<StudentDto> getAllStudent();

    // Update
    String updateStudent(StudentDto studentDto, int rollNumber);

    // Delete
    void delete(int rollNumber);
}
