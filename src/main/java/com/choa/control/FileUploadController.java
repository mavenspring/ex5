package com.choa.control;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.choa.ex5.FileDTO;
import com.choa.util.FileSaver;


@Controller
public class FileUploadController {
	
	@RequestMapping(value="/test/fileUpForm")
	public void fileUp(){
		
	}
	
	//1번째 방법 
	//@RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	public void fileUpload1(String name, MultipartHttpServletRequest request )throws Exception{
		System.out.println("Name : "+name);
		
		String path = request.getSession().getServletContext().getRealPath("resources/upload");
		// 파일의 정보 저장
		MultipartFile mf = request.getFile("f1");
		System.out.println("getName: "+mf.getName());
		System.out.println("getOriginName: "+mf.getOriginalFilename());
		System.out.println("getSize: "+mf.getSize());
		System.out.println("getInputStream : "+mf.getInputStream());
		System.out.println("realPath : "+path);
		FileSaver fs = new FileSaver();
		fs.filesave(path, mf.getOriginalFilename(), mf.getBytes());
	}
	
	/*//파일 디스크에 저장
	private String upload1(MultipartFile mf, String path)throws Exception{
		 System.out.println(path);
		 // 파일명 중복 방지
		 String fileName = UUID.randomUUID().toString();
		 System.out.println(fileName);
		 fileName += "_"+mf.getOriginalFilename();
		 File file = new File(path,fileName);
		 
		 //파일 복사
		 FileCopyUtils.copy(mf.getBytes(),file);
		 
		 return fileName;
	}*/
	
	//2 번째 방법
	//@RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	// MultipartFile 변수명을 parameter 값과 같게 만들어줘야한다
	public void fileUpload2(String name, MultipartFile f1,HttpSession session)throws Exception{
		//RealPath
		String path = session.getServletContext().getRealPath("resources/upload");
		// 파일의 정보 저장

		System.out.println("getName: "+f1.getName());
		System.out.println("getOriginName: "+f1.getOriginalFilename());
		System.out.println("getSize: "+f1.getSize());
		System.out.println("realPath : "+path);
		FileSaver fs = new FileSaver();
		fs.filesave(path, f1.getOriginalFilename(), f1.getBytes());
	}
	
	//3번째
	@RequestMapping(value="/test/fileUp1", method=RequestMethod.POST)
	public void fileUpload3(FileDTO fileDTO, HttpSession session)throws Exception{
		FileSaver fs = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/upload");
		/*String oriName = fileDTO.getF1().getOriginalFilename();
		byte [] fileData = fileDTO.getF1().getBytes();*/
		
		fs.filesave(realPath,fileDTO.getF1());
		
	}
	
	
}
