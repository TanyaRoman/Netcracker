package com.nc.edu.validation;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

public class ResultOfValidation {

    private StatusValidation status;
    private List<String> description;

    public ResultOfValidation() {
        this.status = StatusValidation.OK;
        this.description = new ArrayList<String>();
    }



    public StatusValidation getStatus() {
        return status;
    }

    public void setStatus(StatusValidation status) {
        this.status = status;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.status = StatusValidation.ERROR;
        this.description = description;
    }

    public void addDescription(String string){
        status = StatusValidation.ERROR;
        description.add(string);
    }
}
