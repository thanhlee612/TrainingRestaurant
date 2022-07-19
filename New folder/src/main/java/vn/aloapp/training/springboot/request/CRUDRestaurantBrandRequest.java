package vn.aloapp.training.springboot.request;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CRUDRestaurantBrandRequest extends BaseRequest {

	@JsonProperty("id")
	private int id;

	@NotNull(message = "restaurant_id không được null")
	@JsonProperty("restaurant_id")
	private int restaurantId;

	@NotNull(message = "Tên không được để trống")
	@JsonProperty("name")
	private String name;

	@NotNull(message = "logoUrl không được để trống")
	@JsonProperty("logo_url")
	private String logoUrl;

	@NotNull(message = "banner không được để trống")
	@JsonProperty("banner")
	private String banner;

	@JsonProperty("status")
	private int status;

	@NotNull(message = "description không được để trống")
	@JsonProperty("description")
	private String description;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoUrl() {
		return logoUrl;
	}

	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
