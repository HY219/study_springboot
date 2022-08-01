package com.example.hellorestapi.entity;

import lombok.*;

import javax.persistence.*;

//디자인 패턴 중 하나인 빌더패턴방식으로 객체를 생성할 수 있게해준다.
@Builder
//JPA가 관리하는 클래스 = Entity
//JPA를 사용해서 테이블과 매핑할 클래스는 반드시 @Entity를 붙여야 한다.
@Entity
//lombok을 사용해서 자동으로 get, set메서드를 생성해준다.
@Getter
@Setter
//No : 인자가 없는 생성자를 만들어준다.
//All : 필드의 모든 값을 인자로 갖는 생성자를 만들어준다.
//Required : final로 선언된 값이 필수적인 것만 인자로 받는 생성자를 만들어준다.
@NoArgsConstructor
@AllArgsConstructor
//Entity를 JPA가 관리하도록 했고, 해당 엔티티를 테이블과 매핑하기위해 테이블 지정
//name은 테이블 명이 된다. (default : 엔티티명)
@Table(name = "user")
public class User {

    //primaryKey 임을 명시
    @Id
    //pk값의 새성을 DB에 위임한다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true, length = 30)
    private String email;

    @Column(nullable = false, length = 100)
    private String name;
}
