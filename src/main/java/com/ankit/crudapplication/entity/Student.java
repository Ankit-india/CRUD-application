package com.ankit.crudapplication.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Student")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or GenerationType.AUTO, depending on your database
    private int id;

    @Column(name = "rollNumber")
    private int rollNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "mobileNumber")
    private String mobileNumber;

    @Column(name = "address")
    private String address;

    public static interface IdStep {
        RollNumberStep withId(int id);
    }

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
        Student build();
    }

    public static class Builder
        implements IdStep, RollNumberStep, NameStep, MobileNumberStep, AddressStep, BuildStep {
        private int id;

        private int rollNumber;

        private String name;

        private String mobileNumber;

        private String address;

        private Builder() {
        }

        public static IdStep student() {
            return new Builder();
        }

        @Override
        public RollNumberStep withId(int id) {
            this.id = id;
            return this;
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
        public Student build() {
            Student student = new Student();
            student.setId(this.id);
            student.setRollNumber(this.rollNumber);
            student.setName(this.name);
            student.setMobileNumber(this.mobileNumber);
            student.setAddress(this.address);
            return student;
        }
    }
}
