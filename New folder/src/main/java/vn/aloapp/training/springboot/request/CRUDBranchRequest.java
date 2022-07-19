package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDBranchRequest extends BaseRequest{
	
	@JsonProperty("id")
	private int id;
	
	@NotEmpty(message = "Tên không được để trống")
	private String name;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("restaurant_id")
	private int restaurantId;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("restaurant_brand_id")
	private int restaurantBrandId;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("street_name")
	private String streetName;
	
	@NotNull(message = "không được để trống")
	@JsonProperty("address_full_text")
	private String addressFullText;
	
	@NotEmpty(message = "Số điện thoại không được để trống")
	@JsonProperty("phone_number")
	private String phoneNumber;



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

	
	
}
