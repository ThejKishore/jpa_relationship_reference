package com.kish.jpa.tutorial.dao.embedded.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerId implements Serializable{

    private static final long serialVersionUID = 1L;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "brandcode")
    private String brandcode;

    public CustomerId(){};

    public CustomerId(int customerId, String brandcode){
        this.customerId = customerId;
        this.brandcode = brandcode;
    }

    public void setCustomerId(int customerId){
        this.customerId = customerId;
    }

    public int getCustomerId(){
        return this.customerId;
    }

    public void setBrandcode(String brandcode){
        this.brandcode = brandcode;
    }

    public String getBrandcode(){
        return this.brandcode;
    }
}