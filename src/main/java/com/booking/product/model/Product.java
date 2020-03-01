package com.booking.product.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "products")
@EntityListeners(AuditingEntityListener.class)
public class Product  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "quantity", nullable = false)
	private Integer quantity;
	
	@Column(name = "sale_amount",nullable = false)
	private double saleAmount;
	
	
	 
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Integer getQuantity() {
		return quantity;
	}



	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}



	public double getSaleAmount() {
		return saleAmount;
	}



	public void setSaleAmount(double saleAmount) {
		this.saleAmount = saleAmount;
	}



	@Override
	    public String toString() {
	        return "Product{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", quantity=" + quantity +
	                ", saleAmount='" + saleAmount + '\'' +
	                '}';
	    }
	
}
