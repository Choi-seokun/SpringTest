package hello.hellospring.service;

import hello.hellospring.domain.Student;
import hello.hellospring.repository.Member_Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class Member_Service {
    private final Member_Repository memberRepository;

    public Member_Service(Member_Repository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     */
    public Long join(Student student) {
        validateDuplicateMember(student); //중복 회원 검증
        memberRepository.save(student);
        return student.getId();
    }
    private void validateDuplicateMember(Student student) {
        memberRepository.findByName(student.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    /**
     * 전체 회원 조회
     */
    public List<Student> findMembers() {
        return memberRepository.findAll();
    }
    public Optional<Student> findName(Long memberId) {
        return memberRepository.findById(memberId);
    }
    public Optional<Student> findId(String name) {
        return memberRepository.findByName(name);
    }
    public void Update(Student student) {
        memberRepository.UpdateName(student);
    }
    public void DeleteStudentById(Long Id) {
        memberRepository.DeleteById(Id);
    }
    public void DeleteStudentByName(String Name) {
        memberRepository.DeleteByName(Name);
    }
}
