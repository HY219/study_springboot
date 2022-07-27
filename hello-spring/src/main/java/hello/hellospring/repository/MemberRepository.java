/* 사용할 기능 */
package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

// (Member)회원 객체를 저장하는 저장소 생성
public interface MemberRepository {
    //기능1 //save //회원이 저장소에 저장이 됨 //회원을 저장하면 저장된 회원이 반환됨
    Member save(Member member);
    //기능2 //findById //ID로 회원을 찾는 것 //저장소에서 id로 회원을 찾아올 수 있음
    Optional<Member> findById(Long id);
    //기능3 //findByName //name으로 회원을 찾는 것 //저장소에서 name으로 회원을 찾아올 수 있음
    Optional<Member> findByName(String name);
    //기능4 //findAll //모든 회원 list를 가져옴
    List<Member> findAll();
    /*Optional*/
    //findById, findByName 으로 가져오는데 이것이 null일 수 있다.
    //그럼 null이 반환이 되는데, 이때 Optional로 감싸서 반환하는 것을 선호 //JAVA8 기능 */
}
