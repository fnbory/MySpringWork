package com.fbr.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.fbr.entities.Student;
public interface StudentDao {
	public void Insert(Student student);
	public Student getStudent(Integer id);
	public List<Student> getStudents();
	public void delete(Integer id);
	public void update(Integer id,Student student);
}
