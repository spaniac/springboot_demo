package com.example.demo.models;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/* DB의 각 table과 매핑되도록 설정. */
@Entity
@Table(name = "customer")
// getter & setter 생성. 클래스 & 변수 레벨에서 선언 가능
@Getter @Setter
// toString 메서드 생성
@ToString(exclude = "createdDateTime")
// 인자를 받지 않는 생성자 생성
@NoArgsConstructor
// @NonNull이나 final 변수만 인자로 받는 생성자 생성.
@RequiredArgsConstructor
// 모든 멤버변수를 인자로 받는 생성자 생성.
@AllArgsConstructor
// equals()와 hashcode() 메서드를 생성. callSuper = true이면 부모 클래스도 감안하여 비교.
@EqualsAndHashCode(callSuper = false)
// @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode 를 한 번에 생성
@Data
public class Customer {
    /* @Entity 지정 시 PK를 지정하는 Annotation */
    @Id
    // PK 생성 전략 설정
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    // not null
    @NonNull
    private String firstName;
    @NonNull
    @Column(name = "last_name", length = 255)
    private String lastName;
    // @Entity로 매핑한 table의 각 Column과 매핑되도록 설정. Column 속성 설정 가능.
    // datasource 미지정 오류는 신경안써도 되는 듯? 아마 Datasource config를 만들지 않아서 오류인 듯.
    @Column(name = "created_datetime", length = 255)
    // JPA Auditing. 별도의 Auditing config 필요??
    @CreatedDate
    private Date createdDateTime;
    @Column(name = "recent_login_datetime")
    @CreatedDate
    private Date recentLoginDateTime;
}
