package com.example.demo.models;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

/* JPA CRUD repository 등록(session)
* 기본적으로 제공하는 기능들이 있다. CrudRepository 참조.
* <Entity type, PK type>
* 새 기능을 만들 때는 hibernate query method 생셩 규칙이 있다. docs 참고.
*/
@Repository
// 인스턴스로 생성할 필요가 없는 repository일 때 설정. 보통 공통 repository를 선언하여 필요에 따라 상속하기 위해 사용.
//@NoRepositoryBean
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
