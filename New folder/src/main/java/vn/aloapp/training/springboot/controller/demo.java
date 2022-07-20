package vn.aloapp.training.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import vn.aloapp.training.springboot.entity.AreasEntity;
import vn.aloapp.training.springboot.entity.Branch;
import vn.aloapp.training.springboot.entity.Restaurant;
import vn.aloapp.training.springboot.entity.RestaurantBrand;
import vn.aloapp.training.springboot.entity.TableEntity;
import vn.aloapp.training.springboot.response.*;
import vn.aloapp.training.springboot.service.AreasService;
import vn.aloapp.training.springboot.service.BranchService;
import vn.aloapp.training.springboot.service.RestaurantBrandService;
import vn.aloapp.training.springboot.service.RestaurantService;
import vn.aloapp.training.springboot.service.TableService;

@RestController
@RequestMapping("/api/demo")
public class demo extends BaseController {
	
	@Autowired
	private TableService tableService;
	
	@Autowired
	private AreasService areaService;
	
	@Autowired
	private BranchService branchService;
	
	@Autowired
	private RestaurantBrandService brandService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(value = "", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<BaseResponse> getList() throws Exception {
		BaseResponse response = new BaseResponse();
		List<TableEntity> listTable = tableService.findAllTable();
		List<AreasEntity> listArea = areaService.findAllArea();
		List<Branch> listBranch = branchService.findAllBranch();
		List<RestaurantBrand> listBrand = brandService.findAllRestaurantBrand();
		List<Restaurant> listRestaurants = restaurantService.findAllRestaurant();

		List<AreasResponse> areaResponse = new AreasResponse().mapToListv2(listArea,listTable );
		List<BranchResponse> branchResponses = new BranchResponse().mapToListv2(listBranch, areaResponse);
		List<RestaurantBrandResponse> brandResponse = new RestaurantBrandResponse().mapToListv2(listBrand, branchResponses);
		response.setData(new RestaurantResponse().mapToListv2(listRestaurants, brandResponse));
		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
//	public ResponseEntity<BaseResponse> getId(@Valid @PathVariable(name = "id") int id ) throws Exception {
//		BaseResponse response = new BaseResponse();
//		Restaurant restaurant = restaurantService.findById(id);
//		List<TableEntity> listTable = tableService.findAllTable();
//		List<AreasEntity> listArea = areaService.findAllArea();
//		List<Branch> listBranch = branchService.findAllBranch();
//		List<RestaurantBrand> listBrand = brandService.findAllRestaurantBrand();
//
//		List<AreasResponse> areaResponse = new AreasResponse().mapToListv2(listArea, listTable);
//		List<BranchResponse> branchResponses = new BranchResponse().mapToListv2(listBranch, areaResponse);
//		List<RestaurantBrandResponse> brandResponse = new RestaurantBrandResponse().mapToListv2(listBrand, branchResponses);
//		response.setData(new RestaurantResponse().mapToListv3(restaurant, brandResponse));
//		return new ResponseEntity<BaseResponse>(response, HttpStatus.OK);
//	}
}
