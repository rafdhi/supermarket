package com.eksad.supermarket.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@ToString(callSuper = true)
@DiscriminatorValue("Customer")
public class Customer extends Person{
	
	@Column(name = "card_num")
	private String cardNum;
	
}
