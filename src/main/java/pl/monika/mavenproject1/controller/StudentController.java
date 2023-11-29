package pl.monika.mavenproject1.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.monika.mavenproject1.model.Student;
import pl.monika.mavenproject1.service.StudentService;

@RestController
public class StudentController {
    
    private final StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @PostMapping("/students")
    public Student saveNewStudent(@RequestBody @Valid Student student) {
        return studentService.saveStudent(student);
    }  
    
    @GetMapping("/students")
    public List<Student> getListStudents() {
        return studentService.getAllStudents();
    }
    
    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student newStudent, @PathVariable Long id) {

        return studentService.getStudentById(id)
                .map(x -> {
                    x.setName(newStudent.getName());
                    x.setSurname(newStudent.getSurname());
                    x.setIndexNumber(newStudent.getIndexNumber());
                    x.setTerm(newStudent.getTerm());
                    return studentService.saveStudent(x);
                }).get();
    }
    
    @GetMapping("/students/{id}")
    public Student getOneStudent(@PathVariable Long id) {
         Optional<Student> result = studentService.getStudentById(id);
         return result.orElse(null);
    }
    
    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
