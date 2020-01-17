# Java / Spring Boot 관련 토이 프로젝트

## 개요
Java / Spring Boot 관련 개념을 익히기 위한 토이 프로젝트.

### - Spring Boot 기초 설정

#### properties 자주 사용하는 설정(profile, DB, JPA)
~~~properties
# 프로파일 선택 옵션
spring.profiles.active=default

# datasource driver 설정
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# datasource url 설정
spring.datasource.url=jdbc:mysql://192.168.64.2:3306/demo_database
# database 이름
spring.datasource.name=demo_database
# datasource 계정 이름
spring.datasource.username=root
# datasource 계정 비밀번호
spring.datasource.password=park1733

# 메모리에 저장할 bean 객체 오버라이딩 지원
#spring.main.allow-bean-definition-overriding=true

# -- JPA 관련 설정
# JPA database 플랫폼 설정
spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
spring.jpa.database=mysql
# OSIV(Open Session In View)는 웹 요청이 완료될 때까지 동일한 EntityManager를 갖도록 해줍니다.
#spring.jpa.open-in-view=false
# 콘솔에 JPA 실행 쿼리를 출력
spring.jpa.show-sql=true
# 콘솔에 출력되는 JPA 실행 쿼리를 가독성있게 표현
#spring.jpa.hibernate.format-sql=true
# 데이터베이스 초기화 전략 설정(none, create, create-drop, update, validate)
spring.jpa.hibernate.ddl-auto=create
~~~

### - JPA
#### 영속성 및 JPA 기본 개념
https://tinkerbellbass.tistory.com/24

---
#### All JPA Annotations
https://dzone.com/articles/all-jpa-annotations-mapping-annotations

---
#### JPA 기초 Annotation 정리
https://www.icatpark.com/107

---
#### Spring Data JPA Docs
https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference 

---

### - Lombok
#### 자주 쓰는 Lomnbok Annotations
https://www.daleseo.com/lombok-popular-annotations/

---
