package com.synex.domain;

import javax.persistence.Entity;
import org.springframework.web.multipart.MultipartFile;


public class Uploader {
	
	private String filename;
	
	private MultipartFile files;

	public Uploader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public MultipartFile getFiles() {
		return files;
	}

	public void setFiles(MultipartFile files) {
		this.files = files;
	}
	
	

}
