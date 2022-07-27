package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

//MemoryMemberRepository를 Test
class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //save 메서드가 실행이 됨
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring"); //name을 셋팅 해줌.

        repository.save(member); //repository에 member를 저장 //저장할 때, id가 셋팅이 됨.

        //repository.findById(member.getId());
        Member result = repository.findById(member.getId()).get(); //get으로 바로 꺼내줌.
        assertThat(member).isEqualTo(result); //member는 결과를 가져오는 result와 동일하다. (검증)
        //검증 -> 결과 참인지 확인
        //입력한 값과 결과값(result)이 같은지 확인
        //System.out.println("result = " + (result == member)); //soutv
        //Assertions.assertEquals(member, result); //(기대하는 값, 실제 값)
        //Assertions.assertEquals(member, null); //(기대하는 값, 실제 값) //불일치
        //Assertions.assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        //shift +F6 -> rename
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }


}