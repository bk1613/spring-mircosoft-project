package com.synex.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.synex.domain.Uploader;


@Controller
public class FileController {

	
	public static final String UPLOAD_DIR = "c:/uploads/";
	
	@PostMapping(value = "/uploader")
	//client can submit/uploader a file from a user directory to server
	public ResponseEntity<?> saveFile(@RequestParam MultipartFile filename){
		System.out.println("upload");
		byte[] bytes = new byte[(int) filename.getSize()];
        try {
            bytes = filename.getBytes();  
            System.out.println("The file: "+ bytes.length);
            System.out.println(filename.getOriginalFilename());
            if((bytes.length/1024) <= 100) {
                Path path = Paths.get(UPLOAD_DIR + filename.getOriginalFilename());  
                Files.write(path, bytes);
                return new ResponseEntity<byte[]>(bytes, HttpStatus.CREATED);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        return new ResponseEntity<String>("Maximum upload size exceeded", HttpStatus.INTERNAL_SERVER_ERROR);

	}
	
	@GetMapping(value = "/downloader")
	//download a file from server
	public ResponseEntity<?> getFile(@RequestParam String filename){
		File existFile = new File(UPLOAD_DIR + filename);
		
		if(existFile.exists()) {
			try {
				byte[] bytes2 = Files.readAllBytes(Paths.get(UPLOAD_DIR + filename));
				return new ResponseEntity<>(bytes2, HttpStatus.FOUND);
			}catch (IOException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
			
		}
		
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
		
		
		
	}
}
