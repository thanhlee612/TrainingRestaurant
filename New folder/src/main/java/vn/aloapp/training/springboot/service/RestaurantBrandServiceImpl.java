package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.RestaurantBrandDao;
import vn.aloapp.training.springboot.entity.RestaurantBrand;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDRestaurantBrandRequest;

@Service
@Transactional
public class RestaurantBrandServiceImpl implements RestaurantBrandService {

	@Autowired
	private RestaurantBrandDao dao;

	@Override
	public RestaurantBrand spUCreateRestaurantBrand(CRUDRestaurantBrandRequest w) throws Exception {
		return dao.spUCreateRestaurantBrand(w);
	}

	@Override
	public void spUpdateRestaurantBrand(int id, CRUDRestaurantBrandRequest w) throws Exception {
		dao.spUpdateRestaurantBrand(w);
	}

	@Override
	public void delete(int id) throws Exception {
		dao.delete(id);
	}

	@Override
	public StoreProcedureListResult<RestaurantBrand> spGetListRestaurantBrand(int status) throws Exception {
		return dao.spGetListRestaurantBrand(status);
	}

	@Override
	public StoreProcedureListResult<RestaurantBrand> search(String keyword) throws Exception {
		return dao.search(keyword);
	}

	@Override
	public RestaurantBrand spGDetailRestaurantBrand(int id) throws Exception {
		return dao.spGDetailRestaurantBrand(id);
	}

	@Override
	public StoreProcedureListResult<RestaurantBrand> spCreateRestaurantBrand(String json) throws Exception {
		return dao.spCreateBrand(json);
	}

	@Override
	public List<RestaurantBrand> findAllRestaurantBrand() {
		// TODO Auto-generated method stub
		return dao.findAllRestaurantBrand();
	}


}
