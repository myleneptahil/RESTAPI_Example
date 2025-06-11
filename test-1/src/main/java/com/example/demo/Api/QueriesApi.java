package com.example.demo.Api;

import com.example.demo.Entity.Employee;



import com.example.demo.Entity.Task;
import com.example.demo.Repositories.EmployeeRepository;


import com.example.demo.Repositories.TaskRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/querymethods")
@RequiredArgsConstructor
public class QueriesApi {
	
		@Autowired
	  	private final EmployeeRepository employeeRepository;
		
		@Autowired
	    private final TaskRepository taskRepository;

	    public QueriesApi(EmployeeRepository employeeRepository, TaskRepository taskRepository) {
	        this.employeeRepository = employeeRepository;
	        this.taskRepository = taskRepository;
	    }
	    

	   //OK 
	    @GetMapping("/taskbytime")
	    public ResponseEntity<List<Task>> tasknamed() {
	        List<Task> tasks = taskRepository.findByTime(60);
	        
	        // Debug print
	        System.out.println("Tasks found: " + tasks.size());
	        
	        return ResponseEntity.ok(tasks);
	    }

	    //OK
	    @GetMapping("/alltasks")
	    public ResponseEntity<List<Task>> getAllTasks() {
	        List<Task> allTasks = taskRepository.findAll();
	        
	        // Debug print
	        System.out.println("Total tasks: " + allTasks.size());
	        
	        return ResponseEntity.ok(allTasks);
	    }
}
