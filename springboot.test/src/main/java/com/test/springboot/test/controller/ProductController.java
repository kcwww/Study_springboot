package com.test.springboot.test.controller;

import com.test.springboot.test.domain.Product;
import com.test.springboot.test.service.ProductService;
import com.test.springboot.test.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*") // 요청의 주체 제한하는 부분 개발중에는 전체
@RestController // 사용자 입력을 http 방식 알맞게 서비스 호출
@RequestMapping("/api") //어떤 경로로 사용자의 요청을 받을지 메인주소옆에 api
public class ProductController {

    @Autowired
    ProductServiceImpl productService; // 컨트롤러 -> 서비스 -> 레포지토리

    @GetMapping("/products/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(productService.findById(id)); // entity 는 응답받았을때의 객체 여러가지의 상태가 있음 확인은 커맨드 클릭
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        try {
            ResponseEntity
                    .status(HttpStatus.CREATED) // http 값
                    .body(productService.save(product)); // 사용자에게 입력받은 프로덕트를 json형식으로 넘겨줌
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") long id, // 주소옆에 멤버변수를 어떤걸로 사용할건지
            @RequestBody Product product // post 나 get 같은 경우와 다름, json 기반의 메시지를 사용하는 요청의 경우 사용
    ) {
        try {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.update(id, product));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
        try {
            productService.delete(id);
            ResponseEntity.noContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
