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

import vn.aloapp.training.springboot.entity.Restaurant;
import vn.aloapp.training.springboot.entity.StoreProcedureListResult;
import vn.aloapp.training.springboot.request.CRUDRestaurantRequest;
import vn.aloapp.training.springboot.response.BaseResponse;
import vn.aloapp.training.springboot.response.RestaurantResponse;
import vn.aloapp.training.springboot.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController extends BaseController {
	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> create(@Valid @RequestBody CRUDRestaurantRequest wrappers) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			Restaurant restaurant = restaurantService.spUCreateRestaurant(wrappers);
			if (restaurant == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new RestaurantResponse(restaurant));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/create2", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> createRestaurant(@Valid @RequestBody List<CRUDRestaurantRequest> w)
			throws Exception {
		BaseResponse response = new BaseResponse();
		ObjectMapper mapper = new ObjectMapper();
		try {
			String json = mapper.writeValueAsString(w);
			StoreProcedureListResult<Restaurant> restaurant = restaurantService.spCreateRestaurant(json);
			if (json == null || restaurant == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new RestaurantResponse().mapToList(restaurant.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> update(@Valid @RequestBody CRUDRestaurantRequest wrapper,
			@PathVariable("id") int id) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			restaurantService.spUpdateRestaurant(wrapper.setId(id), wrapper);
			Restaurant restaurants = restaurantService.spGSDetailRestaurant(wrapper.getId());
			response.setData(new RestaurantResponse(restaurants));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getId(@Valid @PathVariable int id) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			Restaurant restaurants = restaurantService.spGSDetailRestaurant(id);
			if (restaurants == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			} else {
				response.setData(new RestaurantResponse(restaurants));
			}
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	// delete
	@RequestMapping(value = "/{id}/delete", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> delete(@Valid @PathVariable int id) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			restaurantService.delete(id);
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	// get List
	@RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getList(@Valid @RequestParam("status") int status) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Restaurant> restaurants = restaurantService.spGListRestaurants(status);
			if (restaurants == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new RestaurantResponse().mapToList(restaurants.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> search(@Valid @RequestParam("keyword") String keyword) throws Exception {
		BaseResponse response = new BaseResponse();
		try {
			StoreProcedureListResult<Restaurant> restaurant = restaurantService.search(keyword);
			if (restaurant == null) {
				response.setStatus(HttpStatus.BAD_REQUEST);
				response.setMessage(HttpStatus.BAD_REQUEST);
			}
			response.setData(new RestaurantResponse().mapToList(restaurant.getResult()));
		} catch (Exception e) {
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setMessageError(e.getMessage());
		}
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
}
