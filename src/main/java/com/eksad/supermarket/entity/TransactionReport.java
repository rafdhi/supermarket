package com.eksad.supermarket.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

@Data
public class TransactionReport {
 
	private BigInteger id;
	private Date date;
	private String product;
	private BigDecimal price;
	private Integer quantity;
	private BigDecimal total; {
		// TODO Auto-generated method stub
		
	}
	
	
}
