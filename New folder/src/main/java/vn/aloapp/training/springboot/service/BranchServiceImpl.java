package vn.aloapp.training.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.aloapp.training.springboot.dao.BranchDao;
import vn.aloapp.training.springboot.entity.Branch;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDBranchRequest;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

	@Autowired
	BranchDao dao;

	@Override
	public void spUpdateBranch(int id, CRUDBranchRequest w) throws Exception {
		dao.spUpdateBranch(w);
	}

	@Override
	public Branch spGetDetailBranch(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGetDetailBranch(id);
	}

	@Override
	public StoreProcedureListResult<Branch> search(String keyword) throws Exception {
		// TODO Auto-generated method stub
		return dao.search(keyword);
	}

	@Override
	public StoreProcedureListResult<Branch> getListBranch(int status) throws Exception {
		// TODO Auto-generated method stub
		return dao.spGListBranch(status);
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public Branch spUCreateBranch(CRUDBranchRequest w) throws Exception {
		// TODO Auto-generated method stub
		return dao.spUCreateBranch(w);
	}

	@Override
	public StoreProcedureListResult<Branch> spCreateBranches(String json) throws Exception {
		// TODO Auto-generated method stub
	  return dao.spCreateBranch(json);
	}

	@Override
	public List<Branch> findAllBranch() {
		// TODO Auto-generated method stub
		return dao.findAllBranch();
	}
}
