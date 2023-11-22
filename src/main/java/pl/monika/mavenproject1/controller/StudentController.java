package pl.monika.mavenproject1.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.monika.mavenproject1.model.Student;
import pl.monika.mavenproject1.service.StudentService;

@RestController
public class StudentController {
    
    private final StudentService studentService;
    
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @RequestMapping(value = "/students", method = RequestMethod.POST, consumes={"application/json"})
    public Student saveStudent(@RequestBody @Valid Student student) {
        return studentService.saveStudent(student);
    }  
    
    @RequestMapping(value = "/students", method = RequestMethod.GET, produces={"application/json"})
    public List<Student> getListStudents() {
        return studentService.getAllStudents();
    }
    
    @RequestMapping(value = "/students/{id}", method = RequestMethod.GET, produces={"application/json"})
    public Student getOneStudent(@PathVariable Long id) {
         Optional<Student> result = studentService.getStudentById(id);
         return result.orElse(null);
    }
    
    @RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
}
