package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController                                  // For the controller you use @RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService; // This BEAN is AUTOWIRED to StudentController Constructor because we
                                                 // put the @Autowired on the constructor and @Service on the
                                                 // StudentService class in its file.

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping                                                   // We want to MAP the student blob coming from the
    public void registerNewStudent(@RequestBody Student student) {    // client by taking it from the @RequestBody.
        studentService.addNewStudent(student);                        // We take a @RequestBody and MAP it into a
    }                                                                 // Student (the arg in this method).




    @DeleteMapping(path = "{studentId}")                           // The path variable to trigger deletion is
    public void deleteStudent(@PathVariable("studentId") Long studentId){    // studentId. We set it in the @DeleteMapping().
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email) {
        studentService.updateStudent(studentId, name, email);
    }
}
