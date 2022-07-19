package vn.aloapp.training.springboot.response;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.AreasEntity;
import vn.aloapp.training.springboot.entity.TableEntity;

public class AreasResponse {

	@JsonProperty("id")
	private int id;

	@JsonProperty("restaurant_id")
	private int restaurantId;

	@JsonProperty("restaurant_brand_id")
	private int restaurantBrandId;

	@JsonProperty("branch_id")
	private int branchId;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("status")
	private int status;

	@JsonProperty("tables")
	private List<TableResponse> listTable;

	public List<TableResponse> getListTable() {
		return listTable;
	}

	public void setListTable(List<TableResponse> listTable) {
		this.listTable = listTable;
	}

	public AreasResponse(AreasEntity e, List<TableResponse> listTable) {
		this.listTable = listTable;
		this.id = e.getId();
		this.restaurantId = e.getRestaurantId();
		this.restaurantBrandId = e.getRestaurantBrandId();
		this.branchId = e.getBranchId();
		this.name = e.getName();
		this.description = e.getDescription();
		this.status = e.isStatus() ? 1 : 0;
	}

	public List<AreasResponse> mapToListv2(List<AreasEntity> entity, List<TableEntity> tables) {
		return entity.stream().map(x -> {
			List<TableEntity> list = tables.stream().filter(y -> y.getAreaId() == x.getId())
					.collect(Collectors.toList());
			List<TableResponse> listTable = new TableResponse().mapToList(list);
			return new AreasResponse(x, listTable);
		}).collect(Collectors.toList());
	}

	public AreasResponse() {
	}

	public AreasResponse(AreasEntity e) {
		this.id = e.getId();
		this.restaurantId = e.getRestaurantId();
		this.restaurantBrandId = e.getRestaurantBrandId();
		this.branchId = e.getBranchId();
		this.name = e.getName();
		this.description = e.getDescription();
		this.status = e.isStatus() ? 1 : 0;
	}

	public List<AreasResponse> mapToList(List<AreasEntity> entity) {
		return entity.stream().map(x -> new AreasResponse(x)).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public int getRestaurantBrandId() {
		return restaurantBrandId;
	}

	public void setRestaurantBrandId(int restaurantBrandId) {
		this.restaurantBrandId = restaurantBrandId;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
