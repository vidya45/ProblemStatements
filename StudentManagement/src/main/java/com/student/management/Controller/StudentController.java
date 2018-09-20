package com.student.management.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.student.management.Domain.Student;
import com.student.management.Domain.StudentRegistrationReply;
import com.student.management.Respoitory.StudentRepository;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	
	StudentRepository studentRepository = new StudentRepository();

	//Register a student and send the status object
	@RequestMapping(method = RequestMethod.POST, value="/register")
	StudentRegistrationReply registerStudent(@RequestBody Student studentregd) {
		return studentRepository.registerStudent(studentregd);
		
	}
	
	//Get student with the provided Id
	@RequestMapping(method = RequestMethod.GET)
	List<Student> getStudents() {
		return studentRepository.getStudents();
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value="/search/{name}")
	Student searchStudent(@PathVariable String name) {
		return studentRepository.searchStudent(name);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT, value="/update")
	ResponseEntity updateStudent(@RequestBody Student studentToUpdate) {
		boolean updated = studentRepository.updateStudent(studentToUpdate);
		if(updated) {
			return ResponseEntity.ok().body("Update successful");
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	@RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
	ResponseEntity deleteStudent(@PathVariable long id) {
		if(studentRepository.deleteStudent(id)) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.unprocessableEntity().build();
		}
	}

}
