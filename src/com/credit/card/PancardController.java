/**
 * 
 */
package com.credit.card;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.credit.card.exception.CredicardException;
import com.credit.card.service.PancardService;

/**
 * @author sairam
 *
 */

@Controller
public class PancardController {

	@Autowired
	PancardService pancardService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView panCardForm() {

		pancardService.getSavePancard();
		return new ModelAndView("pancard", "pancard", new PancardController());
	}

	@RequestMapping(value = "/verifypandcard/{pancard}", method = RequestMethod.GET)
	public ModelAndView verifyPandCard(@PathVariable String pancard) {

		pancard = Optional.ofNullable(pancard)
				.orElseThrow(() -> new CredicardException("Pancard Not Found", HttpStatus.NOT_FOUND));

		return new ModelAndView("pancard", "pancard", pancardService.searchPancard(pancard));
	}

	@RequestMapping(value = "/gpdetails", method = RequestMethod.GET)
	@ResponseBody
	public String getDetails() {

		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		return list.toString();
	}

}
