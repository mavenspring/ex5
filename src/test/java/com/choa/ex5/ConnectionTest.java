package com.choa.ex5;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.member.MemberDTO;
import com.choa.member.student.StudentDAOImpl;
import com.choa.member.student.StudentDTO;

public class ConnectionTest extends TestUnit{
	
	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private StudentDAOImpl studentDAOImpl;
	
	//@Test
	public void test() {
		assertNotNull(sqlSession);
		
	}
	@Test
	public void joinTest()throws Exception{
		StudentDTO studentDTO = new StudentDTO();
		studentDTO.setSid("abc");
		studentDTO.setPhone("010333333");
		studentDTO.setName("hahahah");
		studentDTO.setTid("abc");
		studentDTO.setId("abc");
		studentDTO.setPw("abc");
		studentDTO.setAge(23);
		studentDTO.setFileName("abc");
		studentDTO.setOriName("aaa");
		studentDTO.setGrade("3");
	
		int result = studentDAOImpl.memberJoin(studentDTO);
		System.out.println(result);
		assertNotEquals(0, result);;
	}

}
