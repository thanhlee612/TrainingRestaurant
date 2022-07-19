package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.Restaurant;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDRestaurantRequest;

public interface RestaurantService {

	Restaurant spUCreateRestaurant(CRUDRestaurantRequest w) throws Exception;

	StoreProcedureListResult<Restaurant> spGListRestaurants(int status) throws Exception;

	Restaurant spGSDetailRestaurant(int id) throws Exception;

	StoreProcedureListResult<Restaurant> search(String keyword) throws Exception ;

	void delete(int id) throws Exception ;

	void spUpdateRestaurant(int id, CRUDRestaurantRequest w) throws Exception;
	
	StoreProcedureListResult<Restaurant> spCreateRestaurant(String json) throws Exception;
	
	
	List<Restaurant> findAllRestaurant();
	
	Restaurant findById(int id);
}
