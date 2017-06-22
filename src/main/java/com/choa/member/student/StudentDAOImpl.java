package com.choa.member.student;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.choa.member.MemberDAO;
import com.choa.member.MemberDTO;

@Repository
public class StudentDAOImpl implements MemberDAO{

	@Inject
	private SqlSession sqlSession;
	private final String NAMESPACE_s ="StudentMapper.";
	private final String NAMESPACE_m ="MemberMapper.";
	
	
	@Override
	public int memberJoin(MemberDTO memberDTO) throws Exception {
		System.out.println(memberDTO);
		int result = sqlSession.insert(NAMESPACE_m+"joinMember",memberDTO);
		System.out.println("result :"+result);
		int result2 = sqlSession.insert(NAMESPACE_s+"joinStudent",memberDTO);
		System.out.println("result2:"+result2);
		int total= result +result2;
		return total;
	}


	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE_m+"LoginMember", memberDTO);
		
	}
	
	public StudentDTO memberPage(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE_s+"myPage",memberDTO);
	}


	@Override
	public MemberDTO memberPage(String id) throws Exception {
		
		return sqlSession.selectOne(NAMESPACE_s+"memberPage",id);
	}
	
	//test
	public MemberDTO test(MemberDTO memberDTO)throws Exception{
		return sqlSession.selectOne(NAMESPACE_s+"memberLogin", memberDTO);
	}
	
}
