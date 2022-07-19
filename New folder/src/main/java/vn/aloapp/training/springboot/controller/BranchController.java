package vn.aloapp.training.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.Branch;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDBranchRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.BranchResponse;
import vn.aloapp.training.springboot.service.BranchService;

@RestController
@RequestMapping("/api/branches")
public class BranchController {
	@Autowired
	private BranchService branchService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createBranch(@Valid @RequestBody CRUDBranchRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			Branch branch = branchService.spUCreateBranch(w);
			if (branch == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new BranchResponse(branch));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/create2", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody List<CRUDBranchRequest> w) throws Exception {
		BaseResponse response = new BaseResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(w);
			StoreProcedureListResult<Branch> branch = branchService.spCreateBranches(json);
			if (json == null || branch == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new BranchResponse().mapToList(branch.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> update(@Valid @PathVariable("id") int id, @RequestBody CRUDBranchRequest w)
			throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			branchService.spUpdateBranch(w.setId(id), w);
			Branch branch = branchService.spGetDetailBranch(id);
			response.setData(new BranchResponse(branch));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> search(@RequestParam("keyword") String keyword) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Branch> branch = branchService.search(keyword);
			if(branch == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new BranchResponse().mapToList(branch.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spGListBranch(@RequestParam("status") int status) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Branch> branch = branchService.getListBranch(status);
			if(branch == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new BranchResponse().mapToList(branch.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spGetDetailBranch(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			Branch branch = branchService.spGetDetailBranch(id);
			if(branch == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new BranchResponse(branch));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> delete(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			branchService.delete(id);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
