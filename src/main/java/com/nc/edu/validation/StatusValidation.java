package com.nc.edu.validation;

public enum StatusValidation {
    OK(1),
    ERROR(2);
    private int id;

    StatusValidation(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public StatusValidation getStatus (int id){
        for (StatusValidation statusValidation : StatusValidation.values()){
            if (statusValidation.getId() == id){
                return statusValidation;
            }
        }
        return null;
    }
}
