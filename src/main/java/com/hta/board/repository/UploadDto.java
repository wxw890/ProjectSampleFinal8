package com.hta.board.repository;
//dto를 만든다. 파일 업로드시 제목, 이름, 파일을 dto로 쉽게 저장해서 사용하기 위해서 만듬...  

import org.springframework.web.multipart.MultipartFile;

public class UploadDto {

	private String id;
	MultipartFile files;//Spring 에서 제공하는 upload 
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public MultipartFile getFiles() {
		return files;
	}
	public void setFiles(MultipartFile files) {
		this.files = files;
	}
	
	

	
	
}