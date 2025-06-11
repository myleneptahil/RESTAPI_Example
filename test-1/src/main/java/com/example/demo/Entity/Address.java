package com.example.demo.Entity;

import com.example.demo.DTO.EmployeeDto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
	  	@jakarta.persistence.Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	  	private Long id;
	    private String detail;
	    
	    @OneToOne(mappedBy = "address")
	    private Employee employee;
		public Long id() {
			return this.id;
		}
		public String detail() {
			return this.detail;
		}
}
