package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

/* DB의 각 table과 매핑되도록 설정. */
@Entity
@Table(name = "customer")
@Getter
@Setter
public class Customer {
    /* @Entity 지정 시 PK를 지정하는 Annotation */
    @Id
    // PK 생성 전략 설정
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
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

    protected Customer(){}

    public Customer(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdDateTime = new Date();
        this.recentLoginDateTime = new Date();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
