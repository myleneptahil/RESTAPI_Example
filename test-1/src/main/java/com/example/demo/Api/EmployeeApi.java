package com.example.demo.Api;

import com.example.demo.DTO.EmployeeAddressDTO;
import com.example.demo.DTO.EmployeeDto;


//import com.example.demo.DTO.EmployeeDto;
import com.example.demo.Entity.Employee;

import com.example.demo.Repositories.EmployeeRepository;
import com.example.demo.Services.EmployeeService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeApi {
	
	@Autowired
	private final EmployeeService employeeservice;

	@Autowired
    public EmployeeApi(EmployeeService employeeservice) {
        this.employeeservice = employeeservice;
    }
	 

//  OK
    //localhost:8080/employee
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getbyId(@PathVariable("id") long Id) {

        boolean control = employeeservice.existby(Id);
        if (control)
            System.out.println("Employee is present");
        else
            System.out.println("Employee is not in the Database");
        return new ResponseEntity<EmployeeDto>(employeeservice.getById(Id), HttpStatus.OK);
        
        
    }

    //OK
    @PostMapping
    public ResponseEntity<EmployeeDto> save(@RequestBody EmployeeDto employee) {
        return new ResponseEntity<EmployeeDto>(employeeservice.save(employee), HttpStatus.CREATED);
    }
    
//  OK
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getall() {

        System.out.println("The count is:" + employeeservice.count());
        return new ResponseEntity<List<EmployeeDto>>(employeeservice.getall(), HttpStatus.OK);
    }
  
 // OK
    @GetMapping("/employees-with-addresses")
    public ResponseEntity<List<EmployeeAddressDTO>> getEmployeesWithAddresses() {
        List<EmployeeAddressDTO> employees = employeeservice.findAllEmployeesWithAddresses();
        return ResponseEntity.ok(employees);
    }

    //OK
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> update(@PathVariable("id") long Id, @RequestBody EmployeeDto employeedto) {
        employeedto.setId(Id);
        return new ResponseEntity<EmployeeDto>(employeeservice.update(employeedto), HttpStatus.OK);
    }
    
//  OK
    @DeleteMapping("/{id}")
    public ResponseEntity<EmployeeDto> delete(@PathVariable("id") long Id) {
        return new ResponseEntity<EmployeeDto>(employeeservice.deleteById(Id), HttpStatus.OK);
    }

  
//    OK
    @GetMapping("/test")
    public Employee test() {
        Employee emp = new Employee();
        emp.setFirstName("MyTest");
        emp.setLastName("MyUser");
        emp.setEmail("mytest@example.com");
        emp.setAge(30);
        return emp;
    }


}
