package com.designpattern.prototype.service;

import com.designpattern.prototype.dto.StudentDTO;
import com.designpattern.prototype.model.Student;
import com.designpattern.prototype.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = convertToEntity(studentDTO);
        return convertToDTO(studentRepository.save(student));
    }

    public StudentDTO cloneStudent(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        Student cloneStudent = student.get().createClone();
        cloneStudent.setIdStudent(null);
        return convertToDTO(studentRepository.save(cloneStudent));
    }

    public List<StudentDTO> listStudent() {
        return studentRepository.findAll()
                .stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<StudentDTO> findStudentById(Long id) {
        return studentRepository.findById(id)
                .map(this::convertToDTO);
    }

    public Optional<StudentDTO> updateStudent(Long id, StudentDTO studentDTO) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(studentDTO.getName());
                    student.setRegistry(studentDTO.getRegistry());
                    return convertToDTO(studentRepository.save(student));
                });
    }

    public boolean deleteStudent(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private StudentDTO convertToDTO(Student student) {
        return new StudentDTO(
                student.getIdStudent(),
                student.getName(),
                student.getRegistry()
        );
    }

    private Student convertToEntity(StudentDTO studentDTO) {
        Student student = new Student();
        student.setIdStudent(studentDTO.getIdStudent());
        student.setName(studentDTO.getName());
        student.setRegistry(studentDTO.getRegistry());
        return student;
    }

}
