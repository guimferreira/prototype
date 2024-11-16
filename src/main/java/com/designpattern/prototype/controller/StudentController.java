package com.designpattern.prototype.controller;

import com.designpattern.prototype.dto.StudentDTO;
import com.designpattern.prototype.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/student")
@RequiredArgsConstructor
@RestController
@Slf4j
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@RequestBody StudentDTO studentDTO) {
        log.info("Call createStudent in StudentController with data: {}", studentDTO);
        StudentDTO newStudent = studentService.createStudent(studentDTO);
        return ResponseEntity.ok(newStudent);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> listAllStudents() {
        log.info("Call listAllStudents in StudentController");
        List<StudentDTO> students = studentService.listStudent();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> listStudentById(@PathVariable Long id) {
        log.info("Call listStudentById in StudentController with id: {}", id);
        Optional<StudentDTO> student = studentService.findStudentById(id);
        return student.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudentById(@PathVariable Long id, @RequestBody StudentDTO studentDTO) {
        log.info("Call updateStudentById in StudentController with id: {} and data: {}", id, studentDTO);
        Optional<StudentDTO> studentUpdated = studentService.updateStudent(id, studentDTO);
        return studentUpdated.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        log.info("Call deleteStudent in StudentController with id: {}", id);
        boolean studentDeleted = studentService.deleteStudent(id);
        if (studentDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
