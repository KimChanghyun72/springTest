package com.example.demo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {
	
	@Id //PK 지정
	private Long id;
	@Column(name = "username", length = 100, nullable = false)
	private String name;
	@Transient
	private String phone;
	private String addr;

}
