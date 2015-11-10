package com.david.spring.beers.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.david.spring.beers.dto.Beer;

@Component
public class FileValidator implements Validator {

	@Override
	public boolean supports(Class<?> paramClass) {
		return Beer.class.equals(paramClass);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Beer beer = (Beer) target;
		System.out.println("beer.getName(): " + beer.getName());
		System.out.println("beer.getPicture(): " + beer.getPicture());
		if (beer.getPicture().getSize() == 0) {
			errors.rejectValue("file", "Please select a file.");
		}
	}
}
