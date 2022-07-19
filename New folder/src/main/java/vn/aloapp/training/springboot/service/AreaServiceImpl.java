package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.AreaDao;
import vn.aloapp.training.springboot.entity.Area;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;

@Service
@Transactional
public class AreaServiceImpl implements AreaService {

	@Autowired
	AreaDao dao;

	@Override
	public Area findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<Area> findAll() {
		return dao.findAll();
	}

	@Override
	public Area create(Area entity) {
		return dao.create(entity);
	}

	@Override
	public void update(Area entity) {
		dao.update(entity);
	}

	@Override
	public StoreProcedureListResult<Area> spGlAreas(String name) throws Exception {
		return dao.spGlAreas(name);
	}

	@Override
	public StoreProcedureListResult<Area> spGAllArea() {
		return dao.spGAllArea();
	}
}
