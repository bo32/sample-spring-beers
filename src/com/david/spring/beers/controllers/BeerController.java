package com.david.spring.beers.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.david.spring.beers.dto.Beer;
import com.david.spring.beers.services.BeerService;

@Controller
public class BeerController {
	
	private BeerService beerService;

	@Autowired 
	public void setBeerService(BeerService beerService) {
		this.beerService = beerService;	
	}
	
	@RequestMapping("/createBeer")
	public String createBeer(Model model) {
		model.addAttribute("beer", new Beer());
		return "createBeer";
	}
	
	@RequestMapping(value="/showBeer/{id}", method=RequestMethod.GET)
	public ModelAndView showBeer(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("showBeer");
		Beer beer = beerService.getBeer(id);
		mav.addObject(beer);
		return mav;
	}
	
	@RequestMapping(value="/doCreateBeer", method=RequestMethod.POST)
	public String doCreate(Model model, @Valid Beer beer, BindingResult result) {
		if (result.hasErrors()) {
			/*List<ObjectError> errors = result.getAllErrors();
			for (ObjectError e: errors) {
				System.out.println(e.getDefaultMessage());
			}*/
			return "createBeer";
		}
		beerService.insertBeer(beer);
		model.addAttribute("message", "Beer successfully created.");
		model.addAttribute("css", "success");
		return showBeers(model);
	}
	
	@RequestMapping(value="/editBeer/{id}", method=RequestMethod.GET)
	public ModelAndView editBeer(@PathVariable int id) {
		ModelAndView mav = new ModelAndView("editBeer");
		Beer b = beerService.getBeer(id);
		mav.addObject("beer", b);
		return mav;
	}
	
	@RequestMapping(value="/doEditBeer/{id}", method=RequestMethod.POST)
	public String doEditBeer(Model model, @ModelAttribute Beer beer, @PathVariable int id) {
		beerService.updateBeer(beer);
		String message = "Beer successfully updated.";
		model.addAttribute("message", message);
		return showBeers(model);
	}
	
	@RequestMapping(value="/doDeleteBeer/{id}", method=RequestMethod.GET)
	public String deleteBeer(Model model, @PathVariable int id) {
		beerService.removeBeer(id);
		model.addAttribute("message", "Beer successfully deleted.");
		model.addAttribute("css", "success");
		return showBeers(model);
	}
	
	@RequestMapping("/beers")
	public String showBeers(Model model) {
		List<Beer> beers = beerService.getBeers();
		model.addAttribute("beers", beers);
		return "beers";
	}
}
