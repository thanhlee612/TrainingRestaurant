package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.Area;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;

public interface AreaService {

	Area create(Area entity);

	void update(Area entity);

	Area findById(int id);

	List<Area> findAll();

	StoreProcedureListResult<Area> spGlAreas(String name) throws Exception;
	
	StoreProcedureListResult<Area> spGAllArea();
}
