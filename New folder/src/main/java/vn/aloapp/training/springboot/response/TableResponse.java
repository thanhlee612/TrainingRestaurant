package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.TableEntity;

public class TableResponse {
	@JsonProperty("id")
	private int id;

	@JsonProperty("restaurant_id")
	private int restaurantId;
	
	@JsonProperty("restaurant_brand_id")
	private int restaurantBrandId;
	
	@JsonProperty("branch_id")
	private int branchId;
	
	@JsonProperty("area_id")
	private int areaId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("total_slot")
	private int totalSlot;
	
	@JsonProperty("status")
	private int status;
		
	@JsonProperty("create_at")
	private Date createAt;


	public TableResponse() {}

	public TableResponse(TableEntity e) {
		this.id = e.getId();
		this.restaurantId = e.getRestaurantId();
		this.restaurantBrandId = e.getRestaurantBrandId();
		this.branchId = e.getBranchId();
		this.areaId = e.getAreaId();
		this.name = e.getName();
		this.description = e.getDescription();
		this.totalSlot = e.getTotalSlot();
		this.status = e.isStatus() ? 1 : 0 ;
		this.createAt = e.getCreatedAt();
	}
	public List<TableResponse> mapToList(List<TableEntity> entity){
		return entity.stream().map(x -> new TableResponse(x)).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getAreaId() {
		return areaId;
	}

	public void setAreaId(int areaId) {
		this.areaId = areaId;
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

	public int getTotalSlot() {
		return totalSlot;
	}

	public void setTotalSlot(int totalSlot) {
		this.totalSlot = totalSlot;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

}
