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
@Entity(name="CLIENT_TABLE")
public class Client {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name="CLIENT_ID")
	private Long id;
	@Column(name="CLIENT_FIRSTNAME")
	private String firstName;
	@Column(name="CLIENT_LASTNAME")
	private String lastName;
	@Column(name="CLIENT_PHONE")
	private long phoneNumber;
	@Column(name="CLIENT_ADDRESS")
	private String address;
	

}
