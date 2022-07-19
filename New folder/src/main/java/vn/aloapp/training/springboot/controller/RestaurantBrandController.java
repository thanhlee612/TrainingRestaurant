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

import vn.aloapp.training.springboot.entity.RestaurantBrand;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDRestaurantBrandRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.RestaurantBrandResponse;
import vn.aloapp.training.springboot.service.RestaurantBrandService;

@RestController
@RequestMapping("/api/restaurant-brand")
public class RestaurantBrandController extends BaseController {

	@Autowired
	private RestaurantBrandService brandService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody CRUDRestaurantBrandRequest w) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			RestaurantBrand restaurantBrand = brandService.spUCreateRestaurantBrand(w);
			if(restaurantBrand == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new RestaurantBrandResponse(restaurantBrand));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/create2", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create2(@Valid @RequestBody List<CRUDRestaurantBrandRequest> w) throws Exception {
		BaseResponse response = new BaseResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {		
			String json = mapper.writeValueAsString(w);
			StoreProcedureListResult<RestaurantBrand> brand = brandService.spCreateRestaurantBrand(json);
			if(json == null || brand == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new RestaurantBrandResponse().mapToList(brand.getResult()));
		}
		catch(Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody CRUDRestaurantBrandRequest w, @PathVariable int id)
			throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			brandService.spUpdateRestaurantBrand(w.setId(id), w);
			RestaurantBrand brand = brandService.spGDetailRestaurantBrand(id);
			response.setData(new RestaurantBrandResponse(brand));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getListBrand(@Valid @RequestParam("status") int status) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<RestaurantBrand> restaurantBrand = brandService.spGetListRestaurantBrand(status);
			if(restaurantBrand == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new RestaurantBrandResponse().mapToList(restaurantBrand.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/search", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> search(@Valid @RequestParam("keyword") String keyword) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<RestaurantBrand> restaurantBrand = brandService.search(keyword);
			if(restaurantBrand == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new RestaurantBrandResponse().mapToList(restaurantBrand.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@GetMapping(value = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getDetailResturantBrand(@Valid @PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			RestaurantBrand brand = brandService.spGDetailRestaurantBrand(id);
			if(brand == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new RestaurantBrandResponse(brand));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/{id}/delete", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> deleteResturantBrand(@Valid @PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
		    brandService.delete(id);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
}
