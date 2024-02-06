package hello.hellospring.repository;

import hello.hellospring.domain.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public class Jpa_Member_Repository implements Member_Repository{
    private final EntityManager em;

    public Jpa_Member_Repository(EntityManager em) {
        this.em = em;
    }

    public Student save(Student student) {
        em.persist(student);
        return student;
    }
    public Optional<Student> findById(Long id) {
        Student student = em.find(Student.class, id);
        return Optional.ofNullable(student);
    }
    public void UpdateName(Student student) {
        this.findById(student.getId()).orElse(null).setName(student.getName());
    }
    public List<Student> findAll() {
        return em.createQuery("select s from Student s", Student.class)
                .getResultList();
    }
    public Optional<Student> findByName(String name) {
        List<Student> result = em.createQuery("select s from Student s where s.name = :name", Student.class)
                .setParameter("name", name)
                .getResultList();
        return result.stream().findAny();
    }

    public void DeleteById(Long id) {
        Student student = em.find(Student.class, id);
        em.remove(student);
    }

    public void DeleteByName(String name) {
        Student student = this.findByName(name).orElse(null);
        em.remove(student);
    }
}

