package com.example.demo.Services;


import com.example.demo.DTO.EmployeeAddressDTO;
import com.example.demo.DTO.EmployeeDto;

import com.example.demo.Entity.Employee;
import com.example.demo.Repositories.EmployeeRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

	private final EmployeeRepository employeerepository;
	private final ModelMapper modelmapper;
	
	  // Add a proper constructor with @Autowired annotation
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeerepository = employeeRepository;
        this.modelmapper = modelMapper;
    }

    
	@Override
    public EmployeeDto save(EmployeeDto employeedto) {

        Employee employee=modelmapper.map(employeedto,Employee.class);
        employee=employeerepository.save(employee);
        employeedto=modelmapper.map(employee,EmployeeDto.class);
        return employeedto;
        
	} 
        @Override
        public EmployeeDto update(EmployeeDto employeedto) {

            Employee employee=employeerepository.findById(employeedto.getId()).orElseThrow(()->new IllegalArgumentException());
            employee.setFirstName(employeedto.getFirstName());
            employee.setLastName(employeedto.getLastName());
            employee.setAge(employeedto.getAge());
            employee.setEmail(employeedto.getEmail());
            employee=employeerepository.save(employee);
            employeedto=modelmapper.map(employee,EmployeeDto.class);
            return employeedto;
        }

        
        @Override
        public List<EmployeeDto> getall() {
            List<Employee> employeelist = employeerepository.findAll();
            return employeelist.stream()
                .map(employee -> modelmapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        }
        
        @Override
        public EmployeeDto getById(long Id) {
            Employee employee = employeerepository.findById(Id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found with id: " + Id));
            return modelmapper.map(employee, EmployeeDto.class);
        }

        @Override
        public EmployeeDto deleteById(long Id) {
            Employee employee=employeerepository.findById(Id).orElseThrow(()->new IllegalArgumentException());
            EmployeeDto employeeDto=modelmapper.map(employee,EmployeeDto.class);
            employeerepository.delete(employee);
           // employeerepository.deleteById(Id);
//            Delete list
//            List<Employee> list=employeerepository.findAll();
//            employeerepository.deleteAll(list);
            return employeeDto;
        }

        @Override
        public long count() {
            return employeerepository.count();
        }

        @Override
        public boolean existby(long Id) {
            return employeerepository.existsById(Id);
        }

        @Override
        public List<EmployeeDto> pagination(int offset, int pagesize) {
            Page<Employee> employeeList=employeerepository.findAll(PageRequest.of(offset,pagesize));
            List<EmployeeDto> dtoList=employeeList.stream().map(employee -> modelmapper.map(employee,EmployeeDto.class))
                    .collect(Collectors.toList());
            return dtoList;
        }

        @Override
        public List<EmployeeDto> sorting(String direction, String field) {
            List<Employee> employeeList=new ArrayList<>();
            if(direction.equals("asc") || direction.equals("ASC"))
                employeeList=employeerepository.findAll(Sort.by(Sort.Direction.ASC,field));
            else
                employeeList=employeerepository.findAll(Sort.by(Sort.Direction.DESC,field));
            List<EmployeeDto> dtoList=employeeList.stream().map(employee -> modelmapper.map(employee,EmployeeDto.class))
                    .collect(Collectors.toList());
            return dtoList;
        }  
	
	

		@Override
		public List<EmployeeAddressDTO> findAllEmployeesWithAddresses() {
			return employeerepository.findAllEmployeesWithAddresses();
		}

}
