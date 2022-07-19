package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.RestaurantDao;
import vn.aloapp.training.springboot.entity.Restaurant;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDRestaurantRequest;

@Service("restaurantService")
@Transactional
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantDao dao;

	@Override
	public Restaurant spUCreateRestaurant(CRUDRestaurantRequest w) throws Exception {
		return dao.spUCreateRestaurant(w);
	}
	
	@Override
	public StoreProcedureListResult<Restaurant> spGListRestaurants(int status) throws Exception {
		return dao.spGListRestaurants(status);
	}

	@Override
	public Restaurant spGSDetailRestaurant(int id) throws Exception {
		return dao.spGSDetailRestaurant(id);
	}

	@Override
	public StoreProcedureListResult<Restaurant> search(String keyword) throws Exception {
		return dao.search(keyword);
	}
	
	@Override
	public void delete(int id) throws Exception  {
		dao.delete(id);
	}

	@Override
	public void spUpdateRestaurant(int id, CRUDRestaurantRequest w)throws Exception {
		dao.spUpdateRestaurant(w);
	}

	@Override
	public StoreProcedureListResult<Restaurant> spCreateRestaurant(String json) throws Exception {
		 return dao.spCreateRestaurant(json);
	}

	@Override
	public List<Restaurant> findAllRestaurant() {
		return dao.findAllRestaurant();
	}

	@Override
	public Restaurant findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	

}
