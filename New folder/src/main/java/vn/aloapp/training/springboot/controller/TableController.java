package vn.aloapp.training.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.entity.TableEntity;
import vn.aloapp.training.springboot.request.CRUDTableRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.TableResponse;
import vn.aloapp.training.springboot.service.TableService;

@RestController
@RequestMapping("/api/tables")
public class TableController {
	@Autowired
	private TableService tableService;

	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createTable(@Valid @RequestBody CRUDTableRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			TableEntity table = tableService.spUCreateTable(w);
			if (table == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new TableResponse(table));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/create2", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createRestaurant(@Valid @RequestBody List<CRUDTableRequest> w)
			throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			ObjectMapper mapper = new ObjectMapper();
			String json = mapper.writeValueAsString(w);
			StoreProcedureListResult<TableEntity> table = tableService.spCreateTables(json);
			if (json == null || table == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new TableResponse().mapToList(table.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/{id}/update", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> updateTable(@Valid @PathVariable(name = "id") int id,
			@RequestBody CRUDTableRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			tableService.spUpdateTable(id, w.getRestaurantId(), w.getRestaurantBrandId(), w.getBranchId(),
					w.getAreaId(), w.getName(), w.getDescription(), w.getTotalSlot());
			TableEntity table = tableService.spGetDetailTable(id);
			response.setData(new TableResponse(table));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/{id}/delete", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> deleteTable(@Valid @PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			tableService.delete(id);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spGListTable(@Valid @RequestParam("status") int status) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<TableEntity> table = tableService.spGListTable(status);
			if (table == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new TableResponse().mapToList(table.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spDetailTable(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			TableEntity table = tableService.spGetDetailTable(id);
			if (table == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new TableResponse(table));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spDetailTable(@RequestParam("keyword") String keyword) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<TableEntity> table = tableService.search(keyword);
			if (table == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new TableResponse().mapToList(table.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
