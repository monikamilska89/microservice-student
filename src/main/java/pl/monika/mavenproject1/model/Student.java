package pl.monika.mavenproject1.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.logging.log4j.util.Strings;

@Entity
public class Student implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "surname", nullable = false)
    private String surname;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "index_number", nullable = false)
    private String indexNumber;
    
    private Integer term;
    
    public Student() {
    }
    
    public Student(String name, String surname, String indexNumber, Integer term) {
        if (Strings.isBlank(name) || Strings.isBlank(surname)
                || Strings.isBlank(indexNumber))
            throw new IllegalArgumentException("Niepoprawne dane studenta");
        
        this.name = name;
        this.surname = surname;
        this.indexNumber = indexNumber;
        this.term = term;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getId() {
        return id;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        if (Strings.isBlank(surname)) 
            throw new IllegalArgumentException("Niepoprawne nazwisko");
        this.surname = surname;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        if (Strings.isBlank(name)) 
            throw new IllegalArgumentException("Niepoprawne imię");
        this.name = name;
    }
    
    public String getIndexNumber() {
        return indexNumber;
    }
    
    public void setIndexNumber(String indexNumber) {
        if (Strings.isBlank(indexNumber))
            throw new IllegalArgumentException("Niepoprawny numer indeksu");
        this.indexNumber = indexNumber;
    }
    
    public Integer getTerm() {
        return term;
    }
    
    public void setTerm(Integer term) {
        if (term < 0)
            throw new IllegalArgumentException("Semestr nie może być liczbą ujemną");
        this.term = term;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Student)) return false;
        Student student = (Student) object;
        return (this == student) || (this.id.equals(student.getId())
                && this.name.equals(student.getName())
                && this.surname.equals(student.getSurname())
                && this.indexNumber.equals(student.getIndexNumber())
                && this.term.equals(student.getTerm()));
    }
    
    @Override
    public int hashCode() {
        return this.name.hashCode() + this.surname.hashCode() + this.indexNumber.hashCode();
    }
    
    @Override
    public String toString() {
        return "[id: " + this.id + "] " +  this.name + " " + this.surname
                + ", numer indeksu: " + this.indexNumber + ", semestr: " + this.term;
    }
}
