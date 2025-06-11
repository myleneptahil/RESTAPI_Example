package com.example.demo.Entity;

import jakarta.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name="employees")
//@Table(name = "employees",schema = "newone",uniqueConstraints = @UniqueConstraint(columnNames = "FirstName"),
// indexes = @Index(name = "email_index",columnList = "Email"))
public class Employee {
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name="id")
	   private Long id;
	   private String detail;
	   
	   private int age;
	   
	   @Column(nullable = false,name = "name")
	   private String firstName;
	   
	   @Column(name = "last_name")
	    private String lastName;
	   
	    @Column(unique = true, name = "email")
	    private String email;
	    
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	    @CreationTimestamp
	    @Column(name = "created_date")
	    private Timestamp createdDate;
	    
	    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
	    @UpdateTimestamp
	    @Column(name = "last_update_date")
	    private Timestamp lastUpdateDate;
	    
	    @OneToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "address_id",unique = true)
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
