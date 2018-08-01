package br.com.rezk.environment.api.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import br.com.rezk.environment.service.v1.RestaurantService;

@RestController
public class RestaurantResource {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private Gson gson;

	@RequestMapping(method=RequestMethod.GET, value = "/restaurants", produces=MediaType.APPLICATION_JSON_VALUE)
	public String listRestaurant(){
		return gson.toJson(restaurantService.listRestaurants());
	}
	
}
