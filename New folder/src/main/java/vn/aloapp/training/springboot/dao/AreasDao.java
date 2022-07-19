package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.AreasEntity;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDAreasRequest;

public interface AreasDao {

	AreasEntity spUCreateArea(CRUDAreasRequest w) throws Exception;
	
	void update(CRUDAreasRequest w) throws Exception;

	AreasEntity spGetDetailArea(int id) throws Exception;
	
	StoreProcedureListResult<AreasEntity> spGListArea(int status) throws Exception;
	
	StoreProcedureListResult<AreasEntity> search(String keyword) throws Exception;
	
	void delete(int id) throws Exception;
	
	StoreProcedureListResult<AreasEntity> spCreateArea(String json)throws Exception;
	
	List<AreasEntity> findAllArea();
}
