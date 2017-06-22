package com.choa.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choa.member.MemberDTO;
import com.choa.member.student.StudentServiceImpl;
import com.choa.member.teacher.TeacherDTO;
import com.choa.member.teacher.TeacherServiceImpl;

@Controller
@RequestMapping(value="/member/**")
public class TeacherController {
	
	@Autowired
	private TeacherServiceImpl teacherServiceImpl;
	
	
	@RequestMapping(value="teacherJoin", method=RequestMethod.POST)
	public String memberJoin(TeacherDTO teacherDTO,Model model, HttpSession session)throws Exception{
		System.out.println("teacher");
		int result = teacherServiceImpl.memberJoin(teacherDTO, session);
		String message ="teacher 회원가입 실패";
		if(result>0	){
			message ="teacher 회원가입 성공!";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", "../");
		return "common/result";
	}
	
	@RequestMapping(value="teacherLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		memberDTO = teacherServiceImpl.memberLogin(memberDTO);
		String message="로그인 실패";
		String path ="../";
		if(memberDTO !=null){
			session.setAttribute("member", memberDTO);
			message="로그인 성공";
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("path", path);
		mv.addObject("message", message);
		mv.setViewName("common/result");
		
		return mv;
	}
}
