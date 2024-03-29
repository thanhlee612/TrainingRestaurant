package vn.aloapp.training.springboot.response;

import java.util.List;
import java.util.stream.Collectors;

import vn.aloapp.training.springboot.entity.Area;
public class AreaResponse {

	private int id;

	private String name;
	
	public AreaResponse() {
	}
	
	public AreaResponse(Area entity) {
		this.id =entity.getId();
		this.name = entity.getName();
	}


	public List<AreaResponse> mapToList (List<Area> entiies){
		return entiies.stream().map(x-> new AreaResponse(x)).collect(Collectors.toList());
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
}
