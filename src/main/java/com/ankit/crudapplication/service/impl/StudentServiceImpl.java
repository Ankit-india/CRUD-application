package com.ankit.crudapplication.service.impl;

import com.ankit.crudapplication.converter.StudentConverter;
import com.ankit.crudapplication.dto.StudentDto;
import com.ankit.crudapplication.entity.Student;
import com.ankit.crudapplication.repository.StudentRepository;
import com.ankit.crudapplication.service.StudentService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentConverter studentConverter;

    @Override
    public String addStudent(StudentDto studentDto) {
        Student student = studentConverter.convert(studentDto);
        studentRepository.save(student);
        return ("!!Student " + student.getName() + " added Successfully!!");
    }

    @Override
    public List<StudentDto> getAllStudent() {
        List<Student> studentList = studentRepository.findAll();
        List<StudentDto> studentDtoListResponse = new ArrayList<>();
        for(Student student: studentList) {
            studentDtoListResponse.add(studentConverter.convertToDto(student));
        }

        return studentDtoListResponse;
    }

    @Override
    public String updateStudent(StudentDto studentDto, int rollNumber) {
        Student student = studentRepository.getStudentById(rollNumber);
        student.setAddress(studentDto.getAddress());
        student.setName(studentDto.getName());
        student.setMobileNumber(studentDto.getMobileNumber());
        studentRepository.save(student);
        return "updated Sucessfully";
    }

    @Override
    public void delete(int rollNumber) {
        Student student = studentRepository.getStudentById(rollNumber);
        studentRepository.delete(student);
    }
}
