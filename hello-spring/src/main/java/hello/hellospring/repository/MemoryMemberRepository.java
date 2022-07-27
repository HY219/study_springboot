package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository{

    //메모리 저장
    //Map<키, 값> //Map<id, Member>
    private static Map<Long, Member> store = new HashMap<>();
    //sequence //0, 1, 2 .. 키 값을 생성해주는 것
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence); //member가 추가될 때 마다 ++id //id셋팅
        store.put(member.getId(), member); //store에 저장을 함. -> map에 저장이 됨
        return member; //저장된 결과를 반환
        //return null;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));//null이 반환될 가능성이 있으니, Optional로 감싼다.
        //return store.get(id); //store에서 id를 꺼냄.
        //return Optional.empty();
    }

    @Override
    public Optional<Member> findByName(String name) {
        //JAVA8 람다 사용 //루프로 돌림
        //member에서 member.getName()이 파라미터로 넘어온 name과 동일하면, 필터링이 된다.
        //그중에서 찾으면 반환함.
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //찾아지면 반환. 끝까지 찾았는데 없으면, Optional에 null이 포함되서 반환
        //return Optional.empty();
    }

    @Override
    public List<Member> findAll() {
        //Member들이 반환된다.
        return new ArrayList<>(store.values()); //store에 있는 values() = Member
        //return null;
    }
}
