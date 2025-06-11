package com.example.demo.Services;

import com.example.demo.DTO.EmployeeAddressDTO;
import com.example.demo.DTO.EmployeeDto;


//import com.example.demo.DTO.Employee;
import com.example.demo.Entity.Employee;
import org.springframework.http.HttpStatusCode;


import java.util.List;
public interface EmployeeService {
//	 	public Employee save(Employee employee);
//	 	public List<Employee> getall();
//	 	public EmployeeDto getById(long Id);
//	 	public Employee deleteById(long Id);
//	 	public long count();

	  public EmployeeDto save(EmployeeDto employee);
	  
	  public List<EmployeeAddressDTO> findAllEmployeesWithAddresses(); 
	    public EmployeeDto update(EmployeeDto employeedto);
	    public List<EmployeeDto> getall();
	    public EmployeeDto getById(long Id);
	    public EmployeeDto deleteById(long Id);
	    public long count();
	    public boolean existby(long Id);
	    public List<EmployeeDto> pagination(int offset,int pagesize);
	    public List<EmployeeDto> sorting(String direction,String field);
}
