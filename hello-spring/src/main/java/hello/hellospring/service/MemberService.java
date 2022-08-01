package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.Optional;

public class MemberService {
    //회원 서비스를 만들려면 -> 회원 Repository 있어야함.
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원가입
     */
    public Long join(Member member){
        //같은 이름이 있는 중복 회원x
        //memberRepository.findByName(member.getName()); //memberRepository에서 findByName으로 찾아온 member.getName()
        //ctrl + Alt + v => return을 바로 반환해준다.
        Optional<Member> result = memberRepository.findByName(member.getName());
        //값이 있으면 throw new를 반환
        result.ifPresent(m-> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });

        memberRepository.save(member); //memberRepository의 save를 호출
        return member.getId();
    }
}
