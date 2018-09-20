package com.student.management.Respoitory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.student.management.Domain.Student;
import com.student.management.Domain.StudentRegistrationReply;

public class StudentRepository {
	
	private static List<Student> studentList = new ArrayList<>();
	
	//Get student specific to this ID
	public List<Student> getStudents() {
		return studentList;
	}
	
	//register a student 
	public StudentRegistrationReply registerStudent(Student student) {
		student.setId(student.getId());
		studentList.add(student);
		
		StudentRegistrationReply stdregreply = new StudentRegistrationReply();
		stdregreply.setName(student.getName());
		stdregreply.setRegistrationNumber(new Random().nextInt(1000));
		stdregreply.setRegistrationStatus("Successful");
		return stdregreply;
		
	}
	
	
	public Student searchStudent(String name) {
		for(Student student : studentList) {
			if(student.getName().equalsIgnoreCase(name)) {
				return student;
			} 
		}
		Student noStudent = new Student();
		noStudent.setName("No such student exists");
		return noStudent;
	}
	
	//Update a student
	public boolean updateStudent(Student newStudent) {
		for(Student oldStudent : studentList) {
			if(oldStudent.getId() == newStudent.getId()) {
				oldStudent.setName(newStudent.getName());
				return true;
			}
		}
		return false;
		
	}
	
	//delete a student
	public boolean deleteStudent(long id) {
		Iterator<Student> i = studentList.iterator();
		Student existingStudent;
		while(i.hasNext()) {
			existingStudent = (Student)i.next();
			if(existingStudent.getId() == id) {
				i.remove();
				return true;
			}
		}
		return false;
	}
	
	public static void addStudents()
	{
		Student student = new Student();
		student.setId(123);
		student.setName("Srividya");
		studentList.add(student);
		
	}
}
