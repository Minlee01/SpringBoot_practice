package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**회원가입
     *
     */
    public Long join(Member member){
        //같은 이름을 가진 중복 회원을 안됨
        validateDuplicateMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
/*
        long start = System.currentTimeMillis();

       try{
           validateDuplicateMember(member); //중복회원 검증
           memberRepository.save(member);
           return member.getId();
       }finally{
           long finish = System.currentTimeMillis();
           long timeMs = finish - start;
           System.out.println("join " + timeMs + "ms");
       }
*/
    }
    private void validateDuplicateMember(Member member) {
        //Optional<Member> result = memberRepository.findByName(member.getName());
        memberRepository.findByName(member.getName())
                //result
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    /*
        long start = System.currentTimeMillis();
        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }
     */
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
