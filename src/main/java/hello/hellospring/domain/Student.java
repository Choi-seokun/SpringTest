package hello.hellospring.domain;

import jakarta.persistence.*;

//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Table(name = "student_table")
@Entity
public class Student {
    private String name;
    private  long grade;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }

    public Long getId() {
        return id;
    }
}
