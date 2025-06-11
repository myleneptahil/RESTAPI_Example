package com.example.demo.DTO;
import com.example.demo.Entity.Address;
import com.example.demo.Entity.Employee;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAddressDTO {
	@JsonProperty("id") private Long id;
	@JsonProperty("firstName") private String firstName;
	@JsonProperty("lastName") private String lastName;
	@JsonProperty("email") private String email;
	@JsonProperty("age") private Integer age;
	@JsonProperty("addressId") private Long addressId;
	@JsonProperty("detail") private String detail;

	public EmployeeAddressDTO(
		        Long id, 
		        String firstName, 
		        String lastName, 
		        String email, 
		        Integer age, 
		        Long addressId, 
		        String detail
		    ) {
		        this.id = id;
		        this.firstName = firstName;
		        this.lastName = lastName;
		        this.email = email;
		        this.age = age;
		        this.addressId = addressId;
		        this.detail = detail;
		    }
}
