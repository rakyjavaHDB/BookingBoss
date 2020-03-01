package com.booking.product.controller;

import com.booking.product.model.Product;
import com.booking.product.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * The type User controller.
 *
 * @author Rakesh Thota
 */
@RestController
@RequestMapping("/bookingboss")
public class ProductController {

  
  @Autowired
	private ProductRepository productRepository;

	  @GetMapping("/getProductInfo")
	  public String getProductInfo() {
	    return "welome to Product Info:";
	  }
	  
	  /**
	   * Get all product list.
	   *
	   * @return the list
	   */
	  @GetMapping("/getAllProducts")
	  public List<Product> getAllProducts() {
	    return productRepository.findAll();
	  }

	
	  /**
	   * Create product.
	   *
	   * @param product
	   * @return the product
	   */
	  @PostMapping("/createProduct")
	  public Product createProduct(@Valid @RequestBody Product product) {
		  
		  System.out.println("getId>>>>>>>>>>>>>"+product.getId());
		  System.out.println("getName>>>>>>>>>>>>>"+product.getName());
		  System.out.println("getSaleAmount>>>>>>>>>>>>>"+product.getSaleAmount());
		  System.out.println("getQuantity>>>>>>>>>>>>>"+product.getQuantity());
		  
		  Product productReturn=productRepository.save(product);
		  
	      return productReturn;
	  }

}
