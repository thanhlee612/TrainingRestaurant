package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.Branch;

public class BranchResponse {

	private int id;

	private String name;

	@JsonProperty("restaurant_id")
	private int restaurantId;

	@JsonProperty("restaurant_brand_id")
	private int restaurantBrandId;

	@JsonProperty("streer_name")
	private String streetName;

	@JsonProperty("address_full_text")
	private String addressFullText;

	@JsonProperty("phone_number")
	private String phoneNumber;

	@JsonProperty("status")
	private int status;

	@JsonProperty("create_at")
	private Date createdAt;

	@JsonProperty("areas")
	private List<AreasResponse> listArea;

	public List<AreasResponse> getListArea() {
		return listArea;
	}

	public void setListArea(List<AreasResponse> listArea) {
		this.listArea = listArea;
	}

	public BranchResponse(Branch entity, List<AreasResponse> listArea) {
		this.listArea = listArea;
		this.id = entity.getId();
		this.restaurantId = entity.getRestaurantId();
		this.restaurantBrandId = entity.getRestaurantBrandId();
		this.name = entity.getName();
		this.streetName = entity.getStreetName();
		this.addressFullText = entity.getAddressFullText();
		this.phoneNumber = entity.getPhoneNumber();
		this.createdAt = entity.getCreatedAt();
		this.status = entity.isStatus() ? 1 : 0;
		
	}

	public List<BranchResponse> mapToListv2(List<Branch> entity, List<AreasResponse> a) {
		return entity.stream().map(x -> {
			List<AreasResponse> listArea = a.stream().filter(y -> y.getBranchId() == x.getId()).collect(Collectors.toList());
			return new BranchResponse(x, listArea);
		}).collect(Collectors.toList());
	}

	public BranchResponse() {}
	public BranchResponse(Branch entity) {
		this.id = entity.getId();
		this.restaurantId = entity.getRestaurantId();
		this.restaurantBrandId = entity.getRestaurantBrandId();
		this.name = entity.getName();
		this.streetName = entity.getStreetName();
		this.addressFullText = entity.getAddressFullText();
		this.phoneNumber = entity.getPhoneNumber();
		this.createdAt = entity.getCreatedAt();
		this.status = entity.isStatus() ? 1 : 0;
	}

	public List<BranchResponse> mapToList(List<Branch> entities) {
		return entities.stream().map(x -> new BranchResponse(x)).collect(Collectors.toList());
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getAddressFullText() {
		return addressFullText;
	}

	public void setAddressFullText(String addressFullText) {
		this.addressFullText = addressFullText;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
