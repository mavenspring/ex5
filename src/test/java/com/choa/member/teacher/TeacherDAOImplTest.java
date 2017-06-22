package com.choa.member.teacher;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.choa.ex5.TestUnit;
import com.choa.member.MemberDTO;
import com.choa.member.student.StudentDTO;

public class TeacherDAOImplTest extends TestUnit{

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private TeacherDAOImpl teacherDAOImpl;
	private static TeacherDTO teacherDTO;
	
	//@Test
	public void connectTest_teacher() {
		assertNotNull(sqlSession);
	}
	
	@Test
	public void teacherTest()throws Exception{
		int result = teacherDAOImpl.memberJoin(teacherDTO);
		assertNotEquals(0, result);
	}
	
	@BeforeClass
	public static void makeTeacher(){
		String data ="bbbbbb";
		teacherDTO = new TeacherDTO();
		teacherDTO.setHireDate(null);
		teacherDTO.setSubject(data);
		teacherDTO.setName(data);
		teacherDTO.setTid(data);
		teacherDTO.setId(data);
		teacherDTO.setPw(data);
		teacherDTO.setAge(23);
		teacherDTO.setFileName(data);
		teacherDTO.setOriName(data);
		teacherDTO.setGrade(data);
	}

}
