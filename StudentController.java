package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.services.StudentServices;

@RestController
@RequestMapping("/student")
public class StudentController 
{
     @Autowired
	private StudentServices studentServices;
	
  // build create User REST API
     @PostMapping
     public ResponseEntity<Student> createStudent(@RequestBody Student student){
         Student savedUser = studentServices.createStudent(student);
         return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
     }

     // build get user by id REST API
     // http://localhost:8080/api/users/1
     @GetMapping("/{id}")
     public ResponseEntity<Student> getUserById(@PathVariable("id") Long studentId){
         Student student = studentServices.getStudentById(studentId);
         return new ResponseEntity<>(student, HttpStatus.OK);
     }

     // Build Get All Users REST API
     // http://localhost:8080/api/users
     @GetMapping
     public ResponseEntity<List<Student>> getAllUsers(){
         List<Student> student = studentServices.getAllStudent();
         return new ResponseEntity<>(student, HttpStatus.OK);
     }

     // Build Update User REST API
     @PutMapping("/{id}")
     // http://localhost:8080/api/users/1
     public ResponseEntity<Student> updateStudent(@PathVariable("id") Long studentId,
                                            @RequestBody Student student){
         student.setId(studentId);
         Student updatedSt = studentServices.updateStudent(student);
         return new ResponseEntity<>(updatedSt, HttpStatus.OK);
     }

     // Build Delete User REST API
     @DeleteMapping("/{id}")
     public ResponseEntity<String> deleteStudent(@PathVariable("id") Long studentId){
         studentServices.deleteStudent(studentId);
         return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
     }
     
	
}
