package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Items {

	private int id;
	private String name;
	private int price;
	private String stockQuantity;
	
	public String getPriceAsString() {
		return String.format("%,d", this.getPrice());
	}
}
