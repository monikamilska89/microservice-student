package pl.monika.mavenproject1.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import pl.monika.mavenproject1.service.StudentRepository;
import pl.monika.mavenproject1.service.StudentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceImplTest {
    
    @InjectMocks
    private StudentServiceImpl studentService;

    @Mock
    private StudentRepository studentRepository;
    
    private Student student;
    
    @Before
    public void before() {
        student = new Student("Jan", "Kowalski", "12345", 1);
        student.setId(1L);
    }
    
    @Test
    public void saveStudent() {
        when(studentRepository.save(any(Student.class))).thenReturn(student);
        
        Student savedStudent = studentService.saveStudent(student);
        
        verify(studentRepository, times(1)).save(eq(student));
        
        assertNotNull(savedStudent);
        assertEquals("12345", savedStudent.getIndexNumber());
    }
    
    @Test
    public void getStudent() {
        when(studentRepository.findById(eq(student.getId()))).thenReturn(Optional.of(student));
        
        Optional<Student> result = studentService.getStudentById(student.getId());
        
        verify(studentRepository, times(1)).findById(eq(student.getId()));
        
        assertTrue(result.isPresent());
        assertEquals("12345", result.get().getIndexNumber());
    }
    
    @Test
    public void getAllStudents() {
        Student student2 = new Student("Anna", "Nowak", "12346", 1);
        student2.setId(2L);
        
        List<Student> students = Arrays.asList(
            student, student2
        );
        
        when(studentRepository.findAll()).thenReturn(students);
        
        List<Student> allStudents = studentService.getAllStudents();
        
        verify(studentRepository, times(1)).findAll();
        
        assertFalse(allStudents.isEmpty());
        assertTrue(allStudents.stream().anyMatch(s -> s.getIndexNumber().equals("12345")));
        assertTrue(allStudents.stream().anyMatch(s -> s.getIndexNumber().equals("12346")));
    }
    
    @Test
    public void deleteStudent() {
        Long studentId = 1L;

        studentService.deleteStudent(studentId);

        verify(studentRepository, times(1)).deleteById(eq(studentId));
    }
    
}
