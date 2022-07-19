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

import vn.aloapp.training.springboot.entity.AreasEntity;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDAreasRequest;
import vn.aloapp.training.springboot.response.AreasResponse;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.service.AreasService;

@RestController
@RequestMapping("/api/area")
public class AreasController {
	@Autowired
	private AreasService areasService;

	@PostMapping(value = "/create", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createArea(@Valid @RequestBody CRUDAreasRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			AreasEntity area = areasService.spUCreateArea(w);
			if (area == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new AreasResponse(area));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}

		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/create2", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody List<CRUDAreasRequest> w) throws Exception {
		BaseResponse response = new BaseResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(w);
			StoreProcedureListResult<AreasEntity> areas = areasService.spCreateAreas(json);
			if(json == null || areas == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new AreasResponse().mapToList(areas.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> update(@Valid @RequestBody CRUDAreasRequest w, @PathVariable("id") int id)
			throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			areasService.update(w.setId(id), w);
			AreasEntity area = areasService.spGetDetailArea(w.setId(id));
			response.setData(new AreasResponse(area));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getListAreas(@RequestParam("status") int status) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<AreasEntity> restaurantArea = areasService.spGListArea(status);
			if(restaurantArea == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new AreasResponse().mapToList(restaurantArea.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> spGetDetailArea(@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			AreasEntity area = areasService.spGetDetailArea(id);
			if(area == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new AreasResponse(area));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> search(@RequestParam("keyword") String keyword) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<AreasEntity> restaurantArea = areasService.search(keyword);
			if(restaurantArea == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new AreasResponse().mapToList(restaurantArea.getResult()));
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
			areasService.delete(id);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

}
