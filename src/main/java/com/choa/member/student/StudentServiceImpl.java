package com.choa.member.student;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.choa.member.MemberDTO;
import com.choa.member.MemberService;
import com.choa.util.FileSaver;

@Service
public class StudentServiceImpl implements MemberService{
	
	@Autowired
	private StudentDAOImpl studentDAOImpl;
	
	@Override
	public int memberJoin(MemberDTO memberDTO, HttpSession session) throws Exception {
		
		FileSaver fs = new FileSaver();
	
		memberDTO.setFileName(fs.filesave(session.getServletContext().getRealPath("resources/upload"), memberDTO.getF1()));
		memberDTO.setOriName(memberDTO.getF1().getOriginalFilename());
		
		return studentDAOImpl.memberJoin(memberDTO);
	}

	@Override
	public MemberDTO memberLogin(MemberDTO memberDTO) throws Exception {
		
		return studentDAOImpl.memberLogin(memberDTO);
	}
	
	@Override
	public MemberDTO memberPage(MemberDTO memberDTO)throws Exception{
		
		return studentDAOImpl.memberPage(memberDTO.getId());
	}
	
}
