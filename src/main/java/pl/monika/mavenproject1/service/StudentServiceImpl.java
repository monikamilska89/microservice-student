package pl.monika.mavenproject1.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import pl.monika.mavenproject1.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
    
    private final StudentRepository studentRepository;
    
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    @Override
    @Transactional
    @CacheEvict(value = "cachowanieStudentow", allEntries = true)
    public Student saveStudent(@NotNull @Valid Student student) {
        return this.studentRepository.save(student);
    }
    
    @Override
    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }
    
    @Override
    @Cacheable(value = "cachowanieStudentow")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    @CacheEvict(value = "cachowanieStudentow", allEntries = true)
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
    
}
