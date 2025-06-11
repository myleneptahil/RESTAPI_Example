package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Post {
	 	@jakarta.persistence.Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long Id;
	    private String title;
	    private String content;
	    
	    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
	    private List<Comment> commments;
}
