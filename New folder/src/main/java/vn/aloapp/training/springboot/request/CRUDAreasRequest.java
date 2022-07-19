package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDAreasRequest extends BaseRequest{

	@JsonProperty("id")
	private int id;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("restaurant_id")
	private int restaurantId;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("restaurant_brand_id")
	private int restaurantBrandId;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("branch_id")
	private int branchId;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("name")
	private String name;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("description")
	private String description;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("status")
	private int status;

	public int getId() {
		return id;
	}

	public int setId(int id) {
		this.id = id;
		return id;
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
