package com.choa.ex5;

import org.springframework.web.multipart.MultipartFile;

public class FileDTO {
	
	private String name;
	// 넘어오는 파라미터명과 같아야됨
	private MultipartFile f1;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getF1() {
		return f1;
	}
	public void setF1(MultipartFile f1) {
		this.f1 = f1;
	}
	
}