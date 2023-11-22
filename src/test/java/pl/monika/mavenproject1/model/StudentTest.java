package pl.monika.mavenproject1.model;

import static org.junit.Assert.assertEquals;
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
    
    @Test
    public void setName() {
        student.setName("Jan");
        assertEquals("Jan", student.getName());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setNullSurname() {
        student.setSurname(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setEmptySurname() {
        student.setSurname("");
    }
    
    @Test
    public void setSurname() {
        student.setSurname("Kowalski");
        assertEquals("Kowalski", student.getSurname());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setNullIndexNumber() {
        student.setIndexNumber(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setEmptyIndexNumber() {
        student.setIndexNumber("");
    }
    
    @Test
    public void setIndexNumber() {
        student.setIndexNumber("12345");
        assertEquals("12345", student.getIndexNumber());
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setNegativeTerm() {
        student.setTerm(-1);
    }
    
    @Test
    public void setTerm() {
        student.setTerm(1);
        assertEquals((long) 1, (long) student.getTerm());
    }
}
