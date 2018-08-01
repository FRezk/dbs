package br.com.rezk.environment.service.v1.provider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.rezk.environment.service.dao.RatingDAO;
import br.com.rezk.environment.service.entity.Rating;
import br.com.rezk.environment.service.v1.RatingService;

public class RatingServiceProvider implements RatingService{

	@Autowired
	private RatingDAO ratingDAO;
	
	@Override
	public Rating vote(Rating rating) {
		ratingDAO.persist(rating);
		return rating;
	}

	@Override
	public List<Rating> listRatings() {
		return ratingDAO.list();
	}

}
