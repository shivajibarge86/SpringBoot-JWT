package com.inventory.productinventory.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="PRODUCT_TABLE")
public class Product {
	/**
	 * Description of the property id.
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="PRODUCT_ID")
	private Long id ;
	
	@Column(name="PRODUCT_NAME")
	private String productName;
	
	@Column(name="PRODUCT_COMPANY")
	private String productCompany;
	
	@Column(name="PRODUCT_QTY")
	private Long quentityAvailable;
	
	@Column(name="PRODUCT_AVAILABLE")
	private boolean isAvailable;
	
	@Column(name="PRODUCT_PRICE_PER_UNIT")
	private Long pricePerUnit;
	
	@Column(name="PRODUCT_GST_PER_UNIT")
	private Long GST_PER_UNIT;
	
	@Column(name="PRODUCT_SALE_PRICE")
	private Long salePrice;
	
	
	
	
	

}
