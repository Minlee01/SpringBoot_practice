package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //save하면 회원이 저장소에 저장
    Optional<Member> findById(Long id); //저장소에서 찾아오는 방법
    Optional<Member> findByName(String name);
    List<Member> findAll(); //지금까지 저앚된 모든 회훤 리스트 반환
}
