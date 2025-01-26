package com.example.jpaTutorial.jpaTuts;

import com.example.jpaTutorial.jpaTuts.Entities.ProductEntity;
import com.example.jpaTutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository()
	{

		ProductEntity product2 = new ProductEntity();
		product2.setSku("coca567");
		product2.setTitle("Coca-Cola");
		product2.setPrice(BigDecimal.valueOf(99.99));
		product2.setQuantity(50);
		productRepository.save(product2);

		ProductEntity product3 = new ProductEntity();
		product3.setSku("pepsi890");
		product3.setTitle("Pepsi");
		product3.setPrice(BigDecimal.valueOf(89.99));
		product3.setQuantity(30);
		productRepository.save(product3);

		ProductEntity product4 = new ProductEntity();
		product4.setSku("lays123");
		product4.setTitle("Lays Chips");
		product4.setPrice(BigDecimal.valueOf(49.99));
		product4.setQuantity(100);
		productRepository.save(product4);

		System.out.println("Dummy data inserted successfully!");
	}

	@Test
	void getRepository()
	{
//		List<ProductEntity> entities =
//				productRepository
//						.findBycreatedAtAfter(LocalDateTime.of(2024,1,1,0,0,0));
//		System.out.println(entities);
		Pageable pageable = PageRequest.of(0, 2, Sort.by("title"));

		List<ProductEntity> entities = productRepository.findByTitleContainingIgnoreCase("Pepsi", pageable);
		System.out.println(entities);
	}



}
