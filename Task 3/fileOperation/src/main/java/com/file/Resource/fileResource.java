package com.file.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.file.Service.fileService;
import com.file.model.filePaths;

@RestController
public class fileResource {
	
	@Autowired
	private fileService service;
	
	@RequestMapping(value = "/fileTransfer", method = RequestMethod.POST )
	public void addEmployee(@RequestBody filePaths path) {
		service.fileSafeTransfer(path);
	}
	
}
