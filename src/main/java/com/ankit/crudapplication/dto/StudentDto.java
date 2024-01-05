package com.ankit.crudapplication.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class StudentDto {
    private int rollNumber;
    private String name;
    private String mobileNumber;
    private String address;

    public static interface RollNumberStep {
        NameStep withRollNumber(int rollNumber);
    }

    public static interface NameStep {
        MobileNumberStep withName(String name);
    }

    public static interface MobileNumberStep {
        AddressStep withMobileNumber(String mobileNumber);
    }

    public static interface AddressStep {
        BuildStep withAddress(String address);
    }

    public static interface BuildStep {
        StudentDto build();
    }

    public static class Builder
        implements RollNumberStep, NameStep, MobileNumberStep, AddressStep, BuildStep {
        private int rollNumber;

        private String name;

        private String mobileNumber;

        private String address;

        private Builder() {
        }

        public static RollNumberStep studentDto() {
            return new Builder();
        }

        @Override
        public NameStep withRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
            return this;
        }

        @Override
        public MobileNumberStep withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public AddressStep withMobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        @Override
        public BuildStep withAddress(String address) {
            this.address = address;
            return this;
        }

        @Override
        public StudentDto build() {
            StudentDto studentDto = new StudentDto();
            studentDto.setRollNumber(this.rollNumber);
            studentDto.setName(this.name);
            studentDto.setMobileNumber(this.mobileNumber);
            studentDto.setAddress(this.address);
            return studentDto;
        }
    }
}
