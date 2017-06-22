package com.choa.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.choa.member.MemberDTO;
import com.choa.member.student.StudentDTO;
import com.choa.member.student.StudentServiceImpl;

@Controller
@RequestMapping(value="/member/**")
public class StudentController {
	
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@RequestMapping("memberJoin")
	public void memberJoin(){
		
	}
	@RequestMapping("memberLogin")
	public void memberLogin(){
		
	}
	
	@RequestMapping("memberLogout")
	public String memberLogout(HttpSession session){
		session.invalidate();
		
		return "redirect:/";
	}
	@RequestMapping(value="memberPage", method=RequestMethod.GET)
	public void memberMyPage(HttpSession session,Model model)throws Exception{
		
	    MemberDTO memberDTO =(MemberDTO)session.getAttribute("member");
		MemberDTO memberDTO2 = studentServiceImpl.memberPage(memberDTO);
		model.addAttribute("student", memberDTO2);
	 
	}
	
	@RequestMapping(value="studentLogin", method=RequestMethod.POST)
	public ModelAndView memberLogin(MemberDTO memberDTO, HttpSession session)throws Exception{
		memberDTO = studentServiceImpl.memberLogin(memberDTO);
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
	
	
	@RequestMapping(value="studentJoin", method=RequestMethod.POST)
	public String memberJoin(StudentDTO studentDTO,Model model, HttpSession session)throws Exception{
		System.out.println("student");
		System.out.println("fileName: "+studentDTO.getFileName());
		int result = studentServiceImpl.memberJoin(studentDTO,session);
		String message ="회원가입 실패";
		if(result>0	){
			message ="회원가입 성공!";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", "../");
		return "common/result";
	}
	
	
}
