package vn.aloapp.training.springboot.response;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonProperty;

import vn.aloapp.training.springboot.entity.RestaurantBrand;

public class RestaurantBrandResponse {
	
	private int id;
	
	@JsonProperty("restaurant_id")
	private int restaurantId;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("logo_url")
	private String logoUrl;
	
	@JsonProperty("banner")
	private String banner;
	
	@JsonProperty("status")
	private int status;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("created_at")
	private Date createdAt;
	@JsonProperty("branchs")
	private BranchResponse2 branch2;

	public BranchResponse2 getBranch() {
		return branch2;
	}

	public void setBranch(BranchResponse2 branch2) {
		this.branch2 = branch2;
	}

	public RestaurantBrandResponse(RestaurantBrand e, BranchResponse2 branch2) {
		this.branch2 = branch2;
		this.id = e.getId();
		this.restaurantId = e.getRestaurantId();
		this.name = e.getName();
		this.logoUrl = e.getLogoUrl();
		this.status = e.isStatus() ? 1 : 0;
		this.banner = e.getBanner();
		this.description = e.getDescription();
		this.createdAt = e.getCreatedAt();
	}
	
	public List<RestaurantBrandResponse> mapToListv2( List<RestaurantBrand> entity, List<BranchResponse> branch) {
		return entity.stream().map(x -> {
			List<BranchResponse> listBranch = branch.stream().filter(y -> x.getId() == y.getRestaurantBrandId()).collect(Collectors.toList());
			return new RestaurantBrandResponse(x, new BranchResponse2(listBranch));
		}).collect(Collectors.toList());
	}
	
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public RestaurantBrandResponse() {}

	public RestaurantBrandResponse(RestaurantBrand e) {
		this.id = e.getId();
		this.restaurantId = e.getRestaurantId();
		this.name = e.getName();
		this.logoUrl = e.getLogoUrl();
		this.status = e.isStatus() ? 1 : 0;
		this.banner = e.getBanner();
		this.description = e.getDescription();
		this.createdAt = e.getCreatedAt();
	}
	
	public List<RestaurantBrandResponse> mapToList(List<RestaurantBrand> entity){
		return entity.stream().map(x -> new RestaurantBrandResponse(x)).collect(Collectors.toList());
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
