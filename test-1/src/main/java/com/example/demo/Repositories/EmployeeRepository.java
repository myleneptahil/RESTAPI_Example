package com.example.demo.Repositories;

import com.example.demo.DTO.EmployeeAddressDTO;
import com.example.demo.Entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query("SELECT new com.example.demo.DTO.EmployeeAddressDTO(" +
	           "e.id, e.firstName, e.lastName, e.email, e.age, " +
	           "a.id, a.detail) " + // Matches Address entity field "detail"
	           "FROM Employee e " +
	           "LEFT JOIN e.address a")
	 List<EmployeeAddressDTO> findAllEmployeesWithAddresses();
	 List<Employee> findByFirstName(String firstName);

	    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

	    List<Employee> findByFirstNameOrLastName(String firstName, String lastName);

	    List<Employee> findByEmailContaining(String email);

	    List<Employee> findByAgeGreaterThan(int age);

	    List<Employee> findByAgeLessThan(int age);

	    List<Employee> findByAgeLessThanEqual(int age);

	    List<Employee> findByAgeGreaterThanAndAgeLessThan(int age1, int age2);

	    List<Employee> findByAgeBetween(int age1, int age2);

	    List<Employee> findByFirstNameIn(String[] array);

	    List<Employee> findFirst3ByOrderByFirstNameAsc();

	    List<Employee> findLast3ByOrderByFirstNameDesc();


}
