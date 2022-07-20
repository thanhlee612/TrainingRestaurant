package vn.aloapp.training.springboot.response;

import java.util.List;

public class AreasResponse2 {

    private int total;

    private List<AreasResponse> listAreas;

    public AreasResponse2(List<AreasResponse> listAreas) {
        this.total = listAreas.size();
        this.listAreas = listAreas;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<AreasResponse> getListAreas() {
        return listAreas;
    }

    public void setListAreas(List<AreasResponse> listAreas) {
        this.listAreas = listAreas;
    }
}
