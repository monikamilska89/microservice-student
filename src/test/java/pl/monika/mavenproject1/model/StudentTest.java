package pl.monika.mavenproject1.model;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {
    
    private Student student;
    
    @Before
    public void before() {
        student = new Student();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setNullName() {
        student.setName(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setEmptyName() {
        student.setName("");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setNullSurname() {
        student.setSurname(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setEmptySurname() {
        student.setSurname("");
    }
}
