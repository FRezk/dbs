package br.com.rezk.environment.api.config;

import java.util.Random;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;

import com.google.gson.Gson;

import br.com.rezk.environment.service.dao.CustomerDAO;
import br.com.rezk.environment.service.dao.RatingDAO;
import br.com.rezk.environment.service.dao.RestaurantDAO;
import br.com.rezk.environment.service.entity.Customer;
import br.com.rezk.environment.service.entity.Rating;
import br.com.rezk.environment.service.entity.Restaurant;
import br.com.rezk.environment.service.mapper.CustomerMapper;
import br.com.rezk.environment.service.mapper.ObjMapper;
import br.com.rezk.environment.service.request.CustomerRequest;
import br.com.rezk.environment.service.v1.CustomerService;
import br.com.rezk.environment.service.v1.HomeService;
import br.com.rezk.environment.service.v1.RatingService;
import br.com.rezk.environment.service.v1.RestaurantService;
import br.com.rezk.environment.service.v1.provider.CustomerServiceProvider;
import br.com.rezk.environment.service.v1.provider.HomeServiceProvider;
import br.com.rezk.environment.service.v1.provider.RatingServiceProvider;
import br.com.rezk.environment.service.v1.provider.RestaurantServiceProvider;

@Configuration
public class BeansConfig {

	// Here you config your service beans.
	// Basically, we configure beans from API layer, so we
	// can access using depencendy injection. Example:

	@Bean
	public HomeService homeService() {
		return new HomeServiceProvider();
	}

	@Bean
	public Gson gson() {
		return new Gson();
	}

	@Bean
	public CustomerService customerService() {
		return new CustomerServiceProvider();
	}

	@Bean
	@ApplicationScope
	public Random random() {
		return new Random();
	}
	
	@Bean
	@ApplicationScope
	public CustomerDAO customerDAO() {
		return new CustomerDAO();
	}
	
	@Bean
	@ApplicationScope
	public CustomerMapper customerMapper() {
		return new CustomerMapper();
	}
	
	@Bean
	public RestaurantService restaurantService() {
		return new RestaurantServiceProvider();
	}
	
	@Bean
	public RestaurantDAO restaurantDAO() {
		return new RestaurantDAO();
	}
	
	@Bean
	public RatingService ratingService() {
		return new RatingServiceProvider();
	}
	
	@Bean
	public RatingDAO ratingDAO() {
		return new RatingDAO();
	}

	@Bean()
	public SessionFactory session() {
		// Create session factory
		SessionFactory factory = new org.hibernate.cfg.Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customer.class).addAnnotatedClass(Restaurant.class).addAnnotatedClass(Rating.class).buildSessionFactory();
		return factory;
	}
	
	@Bean(name="customerToRequest")
	public ObjMapper customerToRequest() {
		ObjMapper customerToRequest = (Object entry) -> {
			Customer customer = (Customer) entry;
			CustomerRequest req = new CustomerRequest();
			req.setId(customer.getId());
			req.setName(customer.getName());
			req.setLastName(customer.getLastName());
			req.setAge(customer.getAge());
			return req;
		};
		return customerToRequest;
	}
}
