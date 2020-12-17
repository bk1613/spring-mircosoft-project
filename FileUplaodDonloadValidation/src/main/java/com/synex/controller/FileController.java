package com.synex.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.synex.model.Xfile;
import com.synex.repository.FileRepository;

@RestController
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);

	@Autowired
	FileRepository filerepo;
	
	@PostMapping("/uploader")
	public ResponseEntity<HttpStatus> uploadFile(@RequestParam("fileGroup") String fileGroup, @RequestParam("files") MultipartFile files) {
		System.out.println("upload");
		String fileName = StringUtils.cleanPath(files.getOriginalFilename());
		try {
			if (files.getSize() / 1024 > 100) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
			Xfile xFile = filerepo.findByFileGroupAndFileName(fileGroup, fileName);
			if(xFile == null) {
				xFile = new Xfile();
			}
			xFile.setFileGroup(fileGroup);
			xFile.setFileName(fileName);
			xFile.setFile(files.getBytes());
			filerepo.save(xFile);
			
		} catch (IOException ex) {
			logger.error("Could not save file " + fileName + ". Please try again!", ex);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		catch (Exception ex) {
			logger.error("Could not save file " + fileName + ". Please try again!", ex);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/downloader")
	public ResponseEntity<?> downloadFile(@RequestParam("fileGroup")  String fileGroup, HttpServletResponse response) {
		
		List<Xfile> listXFiles = filerepo.findByFileGroup(fileGroup);
		System.out.println(listXFiles);
		if(listXFiles != null && !listXFiles.isEmpty()) {
//			if(listXFiles.size() > 1) {
				FileOutputStream fos = null;
				File zip = new File("c:/test/"+fileGroup +".zip");
				try {
					fos = new FileOutputStream(zip);
					ZipOutputStream zos = new ZipOutputStream(fos);
					for(Xfile xFile: listXFiles) {
						zos.putNextEntry(new ZipEntry(xFile.getFileName()));
						zos.write(xFile.getFile());
						zos.closeEntry();
					}
					zos.close();
					return new ResponseEntity<>(zos, HttpStatus.OK);
					
				} catch (Exception ex) {
					
					return new ResponseEntity<>(HttpStatus.NOT_FOUND);
				}finally {
					if(fos != null) {
						try {
							fos.close();
						}catch(IOException e){
							e.printStackTrace();
						}
					}
				}
//			}
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}
}
