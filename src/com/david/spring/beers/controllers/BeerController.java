package com.david.spring.beers.controllers;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.david.spring.beers.dto.Beer;
import com.david.spring.beers.services.BeerService;
import com.david.spring.beers.services.RatingService;
import com.david.spring.beers.services.UserService;

@Controller
public class BeerController {
	
	private BeerService beerService;
	private UserService userService;
	private RatingService ratingService;
	
//	@Autowired
//	FileValidator fileValidator;
//	
//	@InitBinder
//	private void initBinder(WebDataBinder binder) {
//		binder.setValidator(fileValidator);
//	}

	@Autowired 
	public void setBeerService(BeerService beerService) {
		this.beerService = beerService;	
	}
	
	@Autowired 
	public void setBeerService(UserService userService) {
		this.userService = userService;	
	}
	
	@Autowired 
	public void setRatingService(RatingService ratingService) {
		this.ratingService = ratingService;	
	}
	
	@RequestMapping(value="/createBeer")
	public String createBeer(Model model) {
		model.addAttribute("beer", new Beer());
		return "createBeer";
	}
	
	@RequestMapping(value="/showBeerPicture/{id}")
	public String showBeerPicture(@PathVariable int id, HttpServletResponse response) {
		System.out.println("Controller showBeerPicture");
		Beer beer = beerService.getBeer(id);
		
		
		response.setContentType("image/png");
		OutputStream o;
		try {
			System.out.println("try");
		    o = response.getOutputStream();
		    o.write(beer.getPictureBytes());
		    o.flush();
		    o.close();
		} catch (IOException e) {
			System.out.println("error");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "showBeerPicture";
	}
	
	@RequestMapping(value="/showBeer/{id}", method=RequestMethod.GET)
	public ModelAndView showBeer(Model model, @PathVariable int id) {
		System.out.println("Controller showBeer");
		ModelAndView mav = new ModelAndView("showBeer");
		Beer beer = beerService.getBeer(id);
		beer.setRating(ratingService.getRating(beer));
		mav.addObject(beer);

//		model.addAttribute("image", beer.getPictureBytes().toString());
//		HTTP does not allow this directly. Each image needs to be a separate request to a separate URL. 
//		So you will need a controller/servlet that accepts the user id as parameter and writes the blob to the response stream 
//		(and sets the Content-Type header appropriately - image/jpeg, image/png, etc)

		return mav;
	}
	
	@RequestMapping(value="/doCreateBeer", method=RequestMethod.POST)
	public String doCreate(Model model, @Validated Beer beer, BindingResult result) {
		/*if (!picture.isEmpty()) {
            try {
                byte[] bytes = picture.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name)));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + "!";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }*/
		if (result.hasErrors()) {
			return "createBeer";
		}
		int beerId = beerService.insertBeer(beer);
		beer.setId(beerId);
		ratingService.insertRating(userService.getConnectedUsername(), beer);
		model.addAttribute("message", "Beer successfully created.");
		model.addAttribute("css", "info");
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
		model.addAttribute("css", "info");
		return showBeers(model);
	}
	
	@RequestMapping(value="/doDeleteBeer/{id}", method=RequestMethod.GET)
	public String deleteBeer(Model model, @PathVariable int id) {
		beerService.removeBeer(id);
		model.addAttribute("message", "Beer successfully deleted.");
		model.addAttribute("css", "info");
		return showBeers(model);
	}
	
	@RequestMapping("/beers")
	public String showBeers(Model model) {
		List<Beer> beers = beerService.getBeers();
		model.addAttribute("beers", beers);
		return "beers";
	}
}
