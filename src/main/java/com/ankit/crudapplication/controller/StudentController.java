package com.ankit.crudapplication.controller;

import com.ankit.crudapplication.dto.StudentDto;
import com.ankit.crudapplication.service.StudentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/createStudent")
    public ResponseEntity<?> addStudent(@RequestBody StudentDto studentDto) {
        String response = studentService.addStudent(studentDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<List<StudentDto>> getAllStudent() {
        List<StudentDto> response = studentService.getAllStudent();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/updateStudent/{rollNumber}")
    public ResponseEntity<?> updateStudent(@PathVariable("rollNumber") int rollNumber,
        @RequestBody StudentDto studentDto) {
        studentService.updateStudent(studentDto, rollNumber);
        return ResponseEntity.ok(
            "!!Student " + studentDto.getName() + " has been updated successfully!!");
    }

    @DeleteMapping("/deleteStudent/{rollNumber}")
    public ResponseEntity<?> deleteStudent(@PathVariable("rollNumber") int rollNumber) {
        try {
            studentService.delete(rollNumber);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("deleted Successfully");
    }
}
