package com.test.springboot.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.springboot.test.domain.Product; // 만든 모델 연결
import org.springframework.stereotype.Repository;

//jpa 에서 지원하는 레포지토리 사용 스프링과 데이터베이스 연동 일련의 처리 담당
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
