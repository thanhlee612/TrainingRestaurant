package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.AreasEntity;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDAreasRequest;

public interface AreasService {
	AreasEntity spUCreateArea(CRUDAreasRequest w) throws Exception;

	void update(int id, CRUDAreasRequest w) throws Exception;

	AreasEntity spGetDetailArea(int id) throws Exception;

	StoreProcedureListResult<AreasEntity> spGListArea(int status) throws Exception;

	StoreProcedureListResult<AreasEntity> search(String keyword) throws Exception;

	void delete(int id) throws Exception;
	
	StoreProcedureListResult<AreasEntity> spCreateAreas(String json)throws Exception;
	
	List<AreasEntity> findAllArea();
}
