package vn.aloapp.training.springboot.service;

import java.util.List;

import vn.aloapp.training.springboot.entity.Branch;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDBranchRequest;

public interface BranchService {
	//void spUCreateBranch (String name,int restaurantId, int restaurantBrandId, String streetName, String addressFullText, String phoneNumber); 

	void spUpdateBranch (int id, CRUDBranchRequest w) throws Exception;
	
	Branch spGetDetailBranch(int id) throws Exception;
	
	StoreProcedureListResult<Branch> search(String keyword) throws Exception;
	
	StoreProcedureListResult<Branch> getListBranch(int status) throws Exception;
	
	void delete(int id) throws Exception;

	Branch spUCreateBranch(CRUDBranchRequest w) throws Exception;

	StoreProcedureListResult<Branch> spCreateBranches(String json) throws Exception;
	
	List<Branch> findAllBranch();
		
}
