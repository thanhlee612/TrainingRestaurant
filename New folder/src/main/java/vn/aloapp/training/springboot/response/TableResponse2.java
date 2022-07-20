package vn.aloapp.training.springboot.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import vn.aloapp.training.springboot.entity.AreasEntity;
import vn.aloapp.training.springboot.entity.TableEntity;

import java.util.List;
import java.util.stream.Collectors;

public class TableResponse2 {
    @JsonProperty("total")
    private int total;
    @JsonProperty("table_response_list")
    private List<TableResponse> tableResponseList;

    public int getTotal() {
        return total;
    }

    public TableResponse2(List<TableResponse> tableResponseList) {
        this.total = tableResponseList.size();
        this.tableResponseList = tableResponseList;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<TableResponse> getTableResponseList() {
        return tableResponseList;
    }

    public void setTableResponseList(List<TableResponse> tableResponseList) {
        this.tableResponseList = tableResponseList;
    }

}
