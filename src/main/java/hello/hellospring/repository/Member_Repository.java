package hello.hellospring.repository;

import hello.hellospring.domain.Student;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;
import java.util.List;
public interface Member_Repository{
    Student save(Student student);
    Optional<Student> findById(Long id);
    void UpdateName(Student student);
    Optional<Student> findByName(String name);
    List<Student> findAll();
    void DeleteByName(String name);
    void DeleteById(Long Id);
}
