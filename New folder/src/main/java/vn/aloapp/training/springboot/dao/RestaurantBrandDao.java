package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.RestaurantBrand;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDRestaurantBrandRequest;

public interface RestaurantBrandDao {

	RestaurantBrand spUCreateRestaurantBrand(CRUDRestaurantBrandRequest w) throws Exception;

	void spUpdateRestaurantBrand(CRUDRestaurantBrandRequest w) throws Exception;
	
	void delete(int id) throws Exception;

	StoreProcedureListResult<RestaurantBrand> spGetListRestaurantBrand(int status) throws Exception;
	
	StoreProcedureListResult<RestaurantBrand> search(String keyword) throws Exception;

	RestaurantBrand spGDetailRestaurantBrand(int id) throws Exception;
	
	StoreProcedureListResult<RestaurantBrand> spCreateBrand(String json) throws Exception;
	
	List<RestaurantBrand> findAllRestaurantBrand();
}
