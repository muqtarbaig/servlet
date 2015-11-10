package org.sample.controller;

import java.util.List;

import javax.validation.Valid;

import org.sample.service.FileValidator;
import org.sample.vo.FileUploadForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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

	 @InitBinder
	private void initBinder(WebDataBinder dataBinder){
		 dataBinder.setValidator(new FileValidator());
	 }
	
	
	@RequestMapping(value = "/home")
	public String uploadHome(){
		return "fileUpload";
	}
	
	
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	
	public  String uploadFile(@Valid @ModelAttribute("uploadForm") FileUploadForm uploadForm, BindingResult result, ModelMap map){
		//http://vmbuild.apache.org/continuum/
		// @RequestParam("myFile") MultipartFile
		if(result.hasErrors())
		{	
			LOGGER.info("Error in upload");
			return "fileUpload";
		}
		
		List<MultipartFile> files = uploadForm.getFiles();
		
		LOGGER.info("file name " +files.get(0).getOriginalFilename() + " :: list size "+files.size());
		//return new ResponseEntity<String>("Success",HttpStatus.OK);
		return "Successful";
	}
	
	

}


