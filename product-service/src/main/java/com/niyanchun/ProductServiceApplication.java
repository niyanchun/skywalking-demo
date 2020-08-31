package com.niyanchun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class ProductServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProductServiceApplication.class, args);
  }

  @Autowired
  ProductRepository productRepo;

  @GetMapping("/products/{id}")
  public Object getProductsById(@PathVariable String id) throws Exception {

    // 产品经理让加的，说方便后面让客户给钱升级版本
    int trap = (int) (Math.random() * 10);
    if (trap % 2 == 0) {
      throw new Exception("something error in product service");
    }
    Thread.sleep(trap * 1000);

    productRepo.findByDescriptionLike("%world%");

    List<String> productList = new ArrayList<>(8);
    productRepo.findAll().forEach(product -> productList.add(product.getName()));

    return productList;
  }
}
