package com.test.springboot.test.service;

import com.test.springboot.test.domain.Product;
import com.test.springboot.test.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository; // service 도 일종의 객체 인스턴스로 생성 되어야함

    @Override
    public Product save(Product product){
        try {
            return productRepository.save( //autowired 로 불러온 레포지토리에 저장
                    new Product(
                            product.getProductName(), // 입력시 받은 프로덕트 get으로 받자
                            product.getPrice()
                    )
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        try {
            Optional<Product> productData = productRepository.findById(id); // null일때 정상적으로 처리해주는 객체
            if (productData.isPresent()) { //optional 에서 지원하는 기능
                return productData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product update(Long id, Product product) {
        try {
            Optional<Product> productData = productRepository.findById(id); // data 를 불러온후
            if (productData.isPresent()) { // 존재한다면
                Product _product = productData.get(); // 가져온 값을 새 객체에 넣고
                _product.setProductName(product.getProductName());
                _product.setPrice(product.getPrice());
                productRepository.save(_product); // db에 저장
                return _product;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        try {
            productRepository.deleteById(id); // id 삭제
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
