package com.student.services;

import java.util.List;


import com.student.model.Student;

public interface StudentServices 
{
	
	Student createStudent(Student student);

    Student getStudentById(Long studentId);

    List<Student> getAllStudent();

    Student updateStudent(Student student);

    void deleteStudent(Long studentId);
	
	
	
}
