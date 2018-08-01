package br.com.rezk.environment.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.rezk.environment.service.entity.Rating;
import br.com.rezk.environment.service.v1.RatingService;

@RestController
public class RatingResource {
	
	@Autowired
	private Gson gson;
	
	@Autowired
	private RatingService ratingService;
	
	@RequestMapping(method=RequestMethod.POST, headers="Content-Type=application/json" , value="/rating", produces=MediaType.APPLICATION_JSON_VALUE)
	public String createCustomer(@RequestBody Rating request) {
		return gson.toJson(ratingService.vote(request));
	}
	
	@RequestMapping(method=RequestMethod.GET, value = "/rating", produces=MediaType.APPLICATION_JSON_VALUE)
	public String listRestaurant(){
		return gson.toJson(ratingService.listRatings());
	}
	
	

}
