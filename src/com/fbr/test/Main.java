package com.fbr.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fbr.dao.StudentDaoImpl;
import com.fbr.entities.Student;
@Service
public class Main {

public static void main(String[] args) {
	ApplicationContext god=new ClassPathXmlApplicationContext("application.xml");
	StudentDaoImpl studentDaoImpl=(StudentDaoImpl) god.getBean("studentDaoImpl");

	System.out.println(studentDaoImpl);
}
}