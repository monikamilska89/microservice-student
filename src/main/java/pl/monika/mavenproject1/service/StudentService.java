package pl.monika.mavenproject1.service;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import pl.monika.mavenproject1.model.Student;

public interface StudentService {
    
    Student saveStudent(@NotNull @Valid Student student);
    Optional<Student> getStudentById(Long id);
    List<Student> getAllStudents();
    void deleteStudent(Long id);
}
