package vn.aloapp.training.springboot.response;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.aspectj.weaver.ArrayReferenceType;
import vn.aloapp.training.springboot.entity.Restaurant;

import javax.persistence.Tuple;

public class RestaurantResponse {

	private int id;

	private String name;

	@JsonProperty("email")
	private String email;

	@JsonProperty("phone")
	private String phone;

	@JsonProperty("info")
	private String info;

	@JsonProperty("address")
	private String address;

	@JsonProperty("logo")
	private String logo;

	@JsonProperty("created_at")
	private Date createdAt;

	@JsonProperty("status")
	private int status;

	@JsonProperty("total")
	private int total;

	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	@JsonProperty("restaurant_brands")
	public RestaurantBrandResponse2 listRestaurantBrand2;

	public RestaurantBrandResponse2 getListRestaurantBrand2() {
		return listRestaurantBrand2;
	}

	public void setListRestaurantBrand2(RestaurantBrandResponse2 listRestaurantBrand2) {
		this.listRestaurantBrand2 = listRestaurantBrand2;
	}

	public RestaurantResponse(Restaurant entity, RestaurantBrandResponse2 listRestaurantBrand2) {
		this.listRestaurantBrand2 = listRestaurantBrand2;
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
		this.info = entity.getInfo();
		this.address = entity.getAddress();
		this.logo = entity.getLogo();
		this.createdAt = entity.getCreatedAt();
		this.status = entity.isStatus() ? 1 : 0;
	}

	public List<RestaurantResponse> mapToListv2(List<Restaurant> entiies, List<RestaurantBrandResponse> rb) {
		return entiies.stream().map(x -> {
			List<RestaurantBrandResponse> list = rb.stream().filter(y -> y.getRestaurantId() == x.getId())
					.collect(Collectors.toList());
			return new RestaurantResponse(x, new RestaurantBrandResponse2(list));
		}).collect(Collectors.toList());
	}

//	public RestaurantResponse mapToListv3(Restaurant r, List<RestaurantBrandResponse> rb) {
//		List<RestaurantBrandResponse> list = rb.stream().filter(y -> y.getRestaurantId() == r.getId())
//				.collect(Collectors.toList());
//		return new RestaurantResponse(r, list);
//	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public RestaurantResponse() {
	}

	public RestaurantResponse(Restaurant entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.email = entity.getEmail();
		this.phone = entity.getPhone();
		this.info = entity.getInfo();
		this.address = entity.getAddress();
		this.logo = entity.getLogo();
		this.createdAt = entity.getCreatedAt();
		this.status = entity.isStatus() ? 1 : 0;
	}

	public List<RestaurantResponse> mapToList(List<Restaurant> entiies) {
		return entiies.stream().map(x -> new RestaurantResponse(x)).collect(Collectors.toList());
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
