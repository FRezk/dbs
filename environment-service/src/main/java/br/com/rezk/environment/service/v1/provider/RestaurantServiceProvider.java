package br.com.rezk.environment.service.v1.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rezk.environment.service.dao.RestaurantDAO;
import br.com.rezk.environment.service.entity.Restaurant;
import br.com.rezk.environment.service.v1.RestaurantService;

public class RestaurantServiceProvider implements RestaurantService {
	
	@Autowired
	private RestaurantDAO restaurantDAO;

	@Override
	public List<Restaurant> listRestaurants() {
		return restaurantDAO.list();
	}

}
