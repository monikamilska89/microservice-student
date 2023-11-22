package pl.monika.mavenproject1.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    
    public Long getId() {
        return id;
    }
    
    public String getSurname() {
        return surname;
    }
    
    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getIndexNumber() {
        return indexNumber;
    }
    
    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }
    
    public Integer getTerm() {
        return term;
    }
    
    public void setTerm(Integer term) {
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
