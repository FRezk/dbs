package br.com.rezk.environment.service.v1;

import java.util.List;

import br.com.rezk.environment.service.entity.Rating;

public interface RatingService {
	public Rating vote(Rating rating);
	public List<Rating> listRatings();

}
