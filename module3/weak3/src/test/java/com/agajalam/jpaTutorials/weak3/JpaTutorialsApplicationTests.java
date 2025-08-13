package com.agajalam.jpaTutorials.weak3;

import com.agajalam.jpaTutorials.weak3.entities.ProductEntity;
import com.agajalam.jpaTutorials.weak3.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class JpaTutorialsApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository(){
		ProductEntity productEntity= ProductEntity.builder()
				.sku("nestle232")
				.title("nestle chocolate")
				.price(BigDecimal.valueOf(200.54))
				.quantity(12)
				.build();
		ProductEntity savedProductEntity=productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository(){
		List<ProductEntity>productEntity=productRepository.findAll();
//		for(ProductEntity product:productEntity){
//			System.out.println(product);
//		}
		System.out.println(productEntity);
	}


	@Test
	void searchRepository(){
//		ProductEntity productEntity=productRepository.findByTitle("fanta");
//		List<ProductEntity> productEntity=productRepository.findByCreatedAtAfter(LocalDateTime.of(2024,1,1,0,0,0));

//		List<ProductEntity> productEntity=productRepository.findByQuantityAndPrice(4,BigDecimal.valueOf(12));

//		List<ProductEntity> productEntity=productRepository.findByQuantityGreaterThanAndPriceLessThan(1,BigDecimal.valueOf(16));
//		List<ProductEntity> productEntity=productRepository.findByQuantityGreaterThanOrPriceLessThan(1,BigDecimal.valueOf(16));

//		List<ProductEntity>productEntity=productRepository.findByTitleContainingIgnoreCase("cOC");

//		Optional<ProductEntity> productEntity=productRepository.findByTitleAndPrice("pepsi",BigDecimal.valueOf(14));
//		productEntity.ifPresent(System.out::println);

//		System.out.println(productEntity);
	}


}
