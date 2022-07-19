package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.AreasDao;
import vn.aloapp.training.springboot.entity.AreasEntity;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDAreasRequest;


@Service
@Transactional
public class AreasServiceImpl implements AreasService {

	@Autowired
	private AreasDao dao;
	
	@Override
	public AreasEntity spUCreateArea(CRUDAreasRequest w) throws Exception{
		return dao.spUCreateArea(w);
	}

	@Override
	public void update(int id, CRUDAreasRequest w) throws Exception {
		dao.update(w);
		
	}

	@Override
	public AreasEntity spGetDetailArea(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGetDetailArea(id);
	}

	@Override
	public StoreProcedureListResult<AreasEntity> spGListArea(int status)throws Exception {
		// TODO Auto-generated method stub
		return dao.spGListArea(status);
	}

	@Override
	public StoreProcedureListResult<AreasEntity> search(String keyword)throws Exception {
		// TODO Auto-generated method stub
		return dao.search(keyword);
	}

	@Override
	public void delete(int id)throws Exception {
		dao.delete(id);
		
	}

	@Override
	public StoreProcedureListResult<AreasEntity> spCreateAreas(String json) throws Exception {
		// TODO Auto-generated method stub
		return dao.spCreateArea(json);
	}

	@Override
	public List<AreasEntity> findAllArea() {
		// TODO Auto-generated method stub
		return dao.findAllArea();
	}


}
