package vn.aloapp.training.springboot.dao;

import java.util.List;

import vn.aloapp.training.springboot.entity.Branch;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDBranchRequest;

public interface BranchDao {
	
	void spUpdateBranch(CRUDBranchRequest w) throws Exception;

	Branch spGetDetailBranch(int id)  throws Exception;
	
	StoreProcedureListResult<Branch> spGListBranch(int status) throws Exception;
	
	StoreProcedureListResult<Branch> search(String keyword) throws Exception;
	
	void delete(int id) throws Exception;

	Branch spUCreateBranch(CRUDBranchRequest w) throws Exception;

	StoreProcedureListResult<Branch> spCreateBranch(String json) throws Exception;
	
	List<Branch> findAllBranch();
}
