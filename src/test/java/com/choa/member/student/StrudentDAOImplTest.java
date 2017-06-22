package com.choa.member.student;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.ex5.TestUnit;
import com.choa.member.MemberDTO;

public class StrudentDAOImplTest extends TestUnit{
	
	@Autowired
	private StudentDAOImpl studentDAOImpl;
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	private static StudentDTO studentDTO;
	
	
	@Test
	public void test11() throws Exception {
		StudentDTO memberDTO = (StudentDTO)studentDAOImpl.test(studentDTO);
		System.out.println("Test Name: "+memberDTO.getName());
		System.out.println("Test Phone :"+memberDTO.getPhone());
	}
	
	@BeforeClass
	public static void makeStudent(){
		String data ="qwer";
		studentDTO = new StudentDTO();
		studentDTO.setPhone(data);
		studentDTO.setName(data);
		studentDTO.setTid(data);
		studentDTO.setId(data);
		studentDTO.setPw(data);
		studentDTO.setAge(23);
		studentDTO.setFileName(data);
		studentDTO.setOriName(data);
		studentDTO.setGrade(data);
	}

}
