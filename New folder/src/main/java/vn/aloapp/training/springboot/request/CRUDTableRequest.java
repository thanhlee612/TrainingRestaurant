package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDTableRequest extends BaseRequest{
	
	@JsonProperty("id")
	private int id;

	@NotNull(message = "restaurantId không được null")
	@JsonProperty("restaurant_id")
	private int restaurantId;
	
	@NotNull(message = "restaurantBrandId không được null")
	@JsonProperty("restaurant_brand_id")
	private int restaurantBrandId;
	
	@NotNull(message = "branchId không được null")
	@JsonProperty("branch_id")
	private int branchId;
	
	@NotNull(message = "areaId không được null")
	@JsonProperty("area_id")
	private int areaId;
	
	@NotEmpty(message = "tên không được để trống")
	@JsonProperty("name")
	private String name;
	
	@NotNull(message = "description không được null")
	@JsonProperty("description")
	private String description;
	
	@NotNull(message = "totalSlot không được null")
	@JsonProperty("total_slot")
	private int totalSlot;
	
	@JsonProperty("status")
	private int status;

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
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
	
	
	
}
