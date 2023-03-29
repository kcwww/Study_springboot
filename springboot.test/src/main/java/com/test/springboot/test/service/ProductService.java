package com.test.springboot.test.service;


import com.test.springboot.test.domain.Product;

import java.util.Optional;

// data 를 처리하는 파트는 service
public interface ProductService {
    public Product save(Product product); // 리턴값 객체
    public Optional<Product> findById(Long id); // 없는 값일때 Optional 은 알아서 처리해줌
    public Product update(Long id, Product product); // id 로 값을 찾고 리턴값 객체
    public void delete(Long id);
}
