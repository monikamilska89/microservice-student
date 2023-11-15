package pl.monika.mavenproject1.service;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.monika.mavenproject1.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    
}
