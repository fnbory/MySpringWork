package com.fbr.handler;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import  org.apache.commons.logging. * ;


import com.fbr.dao.StudentDaoImpl;
import com.fbr.entities.Student;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.bcel.internal.generic.RETURN;
@Controller
public class StudentHandler {
	private static Logger log=Logger.getLogger(StudentHandler.class.getClass());
	//注意此处的autowired是用的spring的IOC容器的，springmvc是可以调用的（子容器），
	//不然会引起servlet初始化失败的异常,直接New出来是空指针异常。
	//private StudentDaoImpl studentDaoImpl=new StudentDaoImpl();
	@Autowired
	private StudentDaoImpl studentImpl;
	@RequestMapping("listall")
	public String listall(Map<String, Object> map) {
		System.out.println("wefwf");
		map.put("students", studentImpl.getStudents());
		System.out.println("wefwfwf");
		log.info("fanborui");
		return "list";		
	}
	@RequestMapping("insert")
	public String insert(Map<String,Object> map) {
		map.put("studt", new Student());  //此处将student（bean）放入request域中，然后才可以在input.jsp中正常显示。
		return "input";
	}
	@RequestMapping(value="operate",method=RequestMethod.PUT)
	public String operat(Student student,@RequestParam(name="id",required=false) int id) {
		System.out.println(student);
		if(id!=0) {
			studentImpl.update(id, student);
			return "redirect:/listall";
		}
		return "redirect:/listall"; 
	}
	@RequestMapping(value="operate",method=RequestMethod.POST)
	public String operate(Student student) {
		studentImpl.Insert(student);
		return "redirect:/listall"; 
	}
	@RequestMapping("delete/{id}")
	public String delete(@PathVariable("id") String id ) {
		studentImpl.delete(Integer.parseInt(id));
		return "redirect:/listall";
	}
	@RequestMapping("update/{id}")
	public String update(@PathVariable("id") Integer id,Map<String, Object> map) {
		map.put("studt", studentImpl.getStudent(id));
		return "input";
	}
	@ModelAttribute
	public void getstudent(@RequestParam(value="id",required=false,defaultValue="0")int id,Map<String, Object> map) {
		if(id!=0) {
		map.put("student",studentImpl.getStudent(21));
		}
	}
}
