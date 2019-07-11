package com.eksad.supermarket.entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import lombok.Data;

@Data
@MappedSuperclass
@Table(name = "brand")
public class BaseEntity {

		@Id
		private Long id;
}
