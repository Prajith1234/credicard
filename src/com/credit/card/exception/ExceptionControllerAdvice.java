package com.credit.card.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(CredicardException.class)
	public ModelAndView missingPancardException(CredicardException ce) {

		ModelAndView m = new ModelAndView();
		m.addObject("errorMsg", ce.getErrorMsg());
		m.addObject("errorCode", ce.getErrorCode());
		m.setViewName("pancard");
		return m;
	}
}
