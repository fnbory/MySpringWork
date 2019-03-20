package com.fbr.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.fbr.entities.Student;
@Component
public class MyRowmapper implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int arg1) throws SQLException {
		Student student=new Student();
		student.setId(rs.getInt("id"));
		student.setName(rs.getString("name"));
		student.setSex(rs.getString("sex"));
		student.setAge(rs.getString("age"));
		student.setPhone(rs.getString("phone"));
		return student;
	}

}
