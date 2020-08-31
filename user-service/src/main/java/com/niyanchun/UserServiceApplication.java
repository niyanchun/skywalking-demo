package com.niyanchun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
public class UserServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(UserServiceApplication.class, args);
  }

  @LoadBalanced
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Autowired
  RestTemplate restTemplate;

  @GetMapping("/users/{id}")
  public Object getUserProducts(@PathVariable String id) {
    String[] products = this.restTemplate.getForObject("http://product-service/products/1", String[].class);
    Map<String, Object> userProducts = new HashMap<>(2);
    userProducts.put("user_id", id);
    userProducts.put("products", products);

    return userProducts;
  }

}
