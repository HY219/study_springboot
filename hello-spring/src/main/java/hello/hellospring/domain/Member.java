/* 데이터 */
package hello.hellospring.domain;

//Member 클래스 생성
public class Member {

//데이터
    //회원ID //ID식별자 //data를 구분하기 위해서 시스템이 저장하는 ID
    private Long id;
    //이름
    private String name;

    //getter setter 만들기
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
