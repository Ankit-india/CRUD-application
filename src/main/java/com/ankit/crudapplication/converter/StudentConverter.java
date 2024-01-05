package com.ankit.crudapplication.converter;

import com.ankit.crudapplication.dto.StudentDto;
import com.ankit.crudapplication.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentConverter {

    public Student convert(StudentDto studentDto) {
        return Student.Builder.student()
            .withId(-1)
            .withRollNumber(studentDto.getRollNumber())
            .withName(studentDto.getName())
            .withMobileNumber(studentDto.getMobileNumber())
            .withAddress(studentDto.getAddress())
            .build();
    }


    public StudentDto convertToDto(Student student) {
        return StudentDto.Builder.studentDto()
            .withRollNumber(student.getId())
            .withName(student.getName())
            .withMobileNumber(student.getMobileNumber())
            .withAddress(student.getAddress())
            .build();
    }
}
