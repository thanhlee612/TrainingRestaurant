package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.TableEntity;
import vn.aloapp.training.springboot.request.CRUDTableRequest;

public interface TableService {
	TableEntity spUCreateTable(CRUDTableRequest w) throws Exception;
	
	void spUpdateTable(int id, int restaurantId, int restaurantBrandId, int branchId, int areaId, String name, String description, int totalSlot) throws Exception;

	TableEntity spGetDetailTable(int id)throws Exception;
	
	StoreProcedureListResult<TableEntity> spGListTable(int status)throws Exception;
	
	StoreProcedureListResult<TableEntity> search(String keyword)throws Exception;
	
	void delete(int id)throws Exception;
	
	StoreProcedureListResult<TableEntity> spCreateTables (String json) throws Exception;
	
	List<TableEntity> findAllTable();
}
