package com.karunesh.springrest.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karunesh.springrest.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
   private List<Student> theStudents;
   
   @PostConstruct
   public void loadData() {
	    theStudents = new ArrayList<Student>();		
		Student student1 = new Student("Karunesh","Maisalge");
		Student student2 = new Student("Lokesh","Maisalge");
		
		theStudents.add(student1);
		theStudents.add(student2);

   }
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
		
	}
	
	@GetMapping("/students/{studentid}")
	public Student getStudent(@PathVariable int studentid ) {
		
		if(studentid >= theStudents.size() || studentid < 0) {
			throw new StudentNotFoundException("Studend it not found - "+ studentid);
		}
		
		return theStudents.get(studentid);
	}
	
	
	
	

}
