package com.example.OnlineShoppingSystem.service;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {

	@Autowired
	ServletContext context;
	
	public void uploadFile(MultipartFile file) throws IllegalStateException, IOException
	{
		String myPath = context.getRealPath("resources/uploads");
		file.transferTo(new File(myPath,file.getName()));
	}
}
