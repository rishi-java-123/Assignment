package com.db.assignment.ecommerce.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productId;

	@Column(length = 2000)
	private String title;

	@Column(length = 5000)
	private String description;

	private Long categoryId;
	private double minimumPrice;
	 private int seller_id;
	@OneToOne
	@JoinColumn(name = "seller_id", updatable = false, insertable = false)
	private User seller;

}
