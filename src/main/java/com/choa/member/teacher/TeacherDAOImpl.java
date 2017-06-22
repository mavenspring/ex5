package com.choa.member.teacher;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.choa.member.MemberDAO;
import com.choa.member.MemberDTO;

@Repository
public class TeacherDAOImpl implements MemberDAO{
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE_t="TeacherMapper.";
	private final String NAMESPACE_m="MemberMapper.";
	
	@Override
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		System.out.println(memberDTO);
		int result = sqlSession.insert(NAMESPACE_m+"joinMember",memberDTO);
		System.out.println("result :"+result);
		int result2 = sqlSession.insert(NAMESPACE_t+"joinTeacher",memberDTO);
		System.out.println("result2:"+result2);
		int total= result +result2;
		
		return total;
	}

	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE_m+"LoginMember", memberDTO);
	}
	
	@Override
	public MemberDTO memberPage(String id) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE_t+"memberPage",id);
	}
	
}
