package vn.aloapp.training.springboot.response;

import java.util.List;

public class RestaurantBrandResponse2 {

    private int total;

    private List<RestaurantBrandResponse> restaurantBrandResponseList;

    public RestaurantBrandResponse2(List<RestaurantBrandResponse> restaurantBrandResponseList) {
        this.total = restaurantBrandResponseList.size();
        this.restaurantBrandResponseList = restaurantBrandResponseList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RestaurantBrandResponse> getRestaurantBrandResponseList() {
        return restaurantBrandResponseList;
    }

    public void setRestaurantBrandResponseList(List<RestaurantBrandResponse> restaurantBrandResponseList) {
        this.restaurantBrandResponseList = restaurantBrandResponseList;
    }
}
