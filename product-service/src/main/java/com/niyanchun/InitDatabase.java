package com.niyanchun;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author NiYanchun
 **/
@Component
public class InitDatabase implements ApplicationRunner {
  @Autowired
  ProductRepository productRepo;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    String[] productNames = new String[]{"audi", "benz", "volvo", "honda"};

    List<Product> productList = new ArrayList<>(8);
    for (String name : productNames) {
      productList.add(new Product(name, "name: " + longString));
    }
    productRepo.saveAll(productList);
  }


  public static String longString = "A car (or automobile) is a wheeled motor vehicle used for transportation. Most definitions of cars say that they run primarily on roads, seat one to eight people, have four tires, and mainly transport people rather than goods.[2][3]\n" +
      "\n" +
      "Cars came into global use during the 20th century, and developed economies depend on them. The year 1886 is regarded as the birth year of the modern car when German inventor Karl Benz patented his Benz Patent-Motorwagen. Cars became widely available in the early 20th century. One of the first cars accessible to the masses was the 1908 Model T, an American car manufactured by the Ford Motor Company. Cars were rapidly adopted in the US, where they replaced animal-drawn carriages and carts, but took much longer to be accepted in Western Europe and other parts of the world.";
}
