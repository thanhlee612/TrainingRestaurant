package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.TableDao;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.TableEntity;
import vn.aloapp.training.springboot.request.CRUDTableRequest;

@Service("tableService")
@Transactional
public class TableServiceImpl implements TableService {
	@Autowired
	private TableDao dao;

	@Override
	public TableEntity spUCreateTable(CRUDTableRequest w) throws Exception {
		return dao.spUCreateTable(w);
	}

	@Override
	public void spUpdateTable(int id, int restaurantId, int restaurantBrandId, int branchId, int areaId, String name,
			String description, int totalSlot)throws Exception {
		dao.spUpdateTable(id, restaurantId, restaurantBrandId, branchId, areaId, name, description, totalSlot);
	}

	@Override
	public TableEntity spGetDetailTable(int id) throws Exception{
		return dao.spGetDetailTable(id);
	}

	@Override
	public StoreProcedureListResult<TableEntity> spGListTable(int status)throws Exception {
		return dao.spGListTable(status);
	}

	@Override
	public StoreProcedureListResult<TableEntity> search(String keyword) throws Exception{
		return dao.search(keyword);
	}

	@Override
	public void delete(int id)throws Exception {
		dao.delete(id);
	}

	@Override
	public StoreProcedureListResult<TableEntity> spCreateTables(String json) throws Exception {
		// TODO Auto-generated method stub
	 return dao.spCreateTable(json);	
	}

	@Override
	public List<TableEntity> findAllTable() {
		return dao.findAllTable();
	}



}
