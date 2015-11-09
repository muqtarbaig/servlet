package org.sample.controller;

import org.sample.vo.FileUploadForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping(value="/upload")
public class UploadController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);


	@RequestMapping(value = "/home")
	public String uploadHome(){
		return "fileUpload";
	}
	
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	
	public @ResponseBody String uploadFile( @RequestParam("myFile") MultipartFile uploadForm, ModelMap map){
		//http://vmbuild.apache.org/continuum/
		
		LOGGER.info("file name " +uploadForm.getOriginalFilename());
		//return new ResponseEntity<String>("Success",HttpStatus.OK);
		return "Successful";
	}
	
	

}


