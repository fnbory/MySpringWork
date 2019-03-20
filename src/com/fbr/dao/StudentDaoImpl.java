package com.fbr.dao;

import java.util.List;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.fbr.entities.Student;

@Service(value="studentDaoImpl")
public class StudentDaoImpl implements StudentDao {
	@Autowired
	 JdbcTemplate jdbcTemplate;
	@Override
	public void Insert(Student student) {
		String sql="insert into student(id,name,sex,age,phone) values (?,?,?,?,?)";
		jdbcTemplate.update(sql, student.getId(),student.getName(),student.getSex(),student.getAge(),student.getPhone());
		

	}

	@Override
	public Student getStudent(Integer id) {
		String sql="select * from student where id=?";
		Student student=jdbcTemplate.queryForObject(sql, new MyRowmapper(), id);
		return student;
	}

	@Override
	public List<Student> getStudents() {
		String  sql="select * from student";
		List<Student> students=jdbcTemplate.query(sql, new MyRowmapper());
		return students;
	}

	@Override
	public void delete(Integer id) {
		String sql="delete from student where id=?";
		jdbcTemplate.update(sql,id);
	}

	@Override
	public void update(Integer id,Student student) {
		String sql="update student set sex=?,age=?,phone=? where id="+id;
		jdbcTemplate.update(sql,student.getSex(),student.getAge(),student.getPhone() );
	}

}
