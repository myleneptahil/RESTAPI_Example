package com.example.demo.DTO;

import java.sql.*;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.demo.Entity.Address;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="employees")
public class EmployeeDto {
	@Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	   
	   private int age;
	   
	   @Column(nullable = false,name = "name")
	    private String firstName;
	   
	   @Column(name = "last_name")
	    private String lastName;
	   
	    @Column(unique = true)
	    private String email;
	    
//	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
//	    @CreationTimestamp
//	    @Column(name = "created_date")
//	    private Timestamp createdDate;
//	    
//	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
//	    @UpdateTimestamp
//	    @Column(name = "last_update_date")
//	    private Timestamp lastUpdateDate;
	    
	    
	    @OneToOne(cascade = CascadeType.ALL)
	    @JoinColumn(name = "address_id",referencedColumnName = "id")
	    private Address address;
	    

    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
	
	public String getLastName() {
        return lastName;
    }
    
	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}
	
	public String getEmail() {
        return email;
    }
	
	public void setEmail(String email) {
		this.email = email;
		
	}
	
	public int getAge() {
        return age;
    }
	
	public void setAge(int age) {
		this.age = age;
		
	}
	
	// Getter for id
    public Long getId() {
        return id;
    }
    
    // Setter for id
    public void setId(Long id) {
        this.id = id;
    }




}
