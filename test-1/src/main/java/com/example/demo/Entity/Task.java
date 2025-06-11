package com.example.demo.Entity;

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
@NamedQuery(name = "Task.findByTime", query = "SELECT t FROM Task t WHERE t.time > :time")
public class Task {
	 	@jakarta.persistence.Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long Id;
	    private String name;
	    //private int time;
	    
	    @Column(name = "time")  
	    private Integer time;
	    
	    public Long getId() {
	        return Id;
	    }

	    public void setId(Long id) {
	        this.Id = Id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Integer getTime() {
	        return time;
	    }

	    public void setTime(Integer time) {
	        this.time = time;
	    }
}
