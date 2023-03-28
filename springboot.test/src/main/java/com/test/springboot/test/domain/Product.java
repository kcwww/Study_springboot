package com.test.springboot.test.domain;

import javax.persistence.*;
// ?

@Entity // jpa 와 spring boot 연결
@Table(name="products") // 이름 설정
public class Product {
    @Id //고유한 객체
    @GeneratedValue(strategy = GenerationType.AUTO) // 숫자를 부여하는 규칙
    private Long id;

    @Column(name = "product_name") // 열 , 항목의 이름
    private String productName;

    @Column(name = "price") // 가격 최상단 열에 물건 이름 , 가격 이런식
    private int price;

    public Product() {} // 빈 생성자가 필요한 경우가 있음 왜 이러한 것인지 ?
    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
    }

    //getter setter 데이터에 접근할수 있도록

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

}