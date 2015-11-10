package org.sample.service;

import org.sample.vo.FileUploadForm;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return FileUploadForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		FileUploadForm form = (FileUploadForm)target;
		
		if(form.getFiles().get(0).getOriginalFilename().toLowerCase().contains("png"))
			errors.reject("error.invalid.file","Files containing png not accepted");
		
	}

}
