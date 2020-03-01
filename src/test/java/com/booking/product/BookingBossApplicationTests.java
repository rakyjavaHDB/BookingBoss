package com.booking.product;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.booking.product.model.Product;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookingBossApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BookingBossApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	public void contextLoads() {
	}

	@Test
	public void testGetAllProducts() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/bookingboss/getAllProducts",
				HttpMethod.GET, entity, String.class);

		Assert.assertNotNull(response.getBody());
		System.out.println("response.getBody()>>>>>>>>>>>>>>>>>>>"+response.getBody());
	}

	
	@Test
	public void testCreateProduct() {
		Product product = new Product();
		product.setId(102);
		product.setName("Rakesh");
		product.setQuantity(122);
		product.setSaleAmount(122.56);

		ResponseEntity<Product> postResponse = restTemplate.postForEntity(getRootUrl() + "/bookingboss/createProduct", product, Product.class);
		Assert.assertNotNull(postResponse);
		Assert.assertNotNull(postResponse.getBody());
		System.out.println("postResponse.getBody()>>>>>>>>>>>>>>>>>>>"+postResponse.getBody());
	}

	

}
