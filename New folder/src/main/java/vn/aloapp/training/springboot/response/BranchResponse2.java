package vn.aloapp.training.springboot.response;

import java.util.List;

public class BranchResponse2 {
    private int total;
    private List<BranchResponse> branchResponseList;

    public BranchResponse2(List<BranchResponse> branchResponseList) {
        this.total = branchResponseList.size();
        this.branchResponseList = branchResponseList;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<BranchResponse> getBranchResponseList() {
        return branchResponseList;
    }

    public void setBranchResponseList(List<BranchResponse> branchResponseList) {
        this.branchResponseList = branchResponseList;
    }
}
