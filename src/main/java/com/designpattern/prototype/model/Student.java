package com.designpattern.prototype.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Student implements Cloneable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idStudent;
    private String name;
    private String registry;

    @Override
    public Student clone() {
        try {
            Student student = (Student) super.clone();
            student.setIdStudent(null);
            return student;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public Student createClone() {
        return this.clone();
    }
}
