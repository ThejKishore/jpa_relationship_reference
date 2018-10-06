package com.kish.jpa.tutorial.dao.embedded.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.json.JSONArray;
import org.json.JSONObject;

@Entity
public class Customer {

    @EmbeddedId
    private CustomerId customerId;

    private String company;
    private String name;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private Set<OrderDetail> orderDetails;

    public Customer(){}

    public Customer(CustomerId customerId, String company, String name){
        this.customerId = customerId;
        this.company = company;
        this.name = name;
    }

    public Customer(CustomerId customerId, String company, String name, Set<OrderDetail> orderDetails){
        this.customerId = customerId;
        this.company = company;
        this.name = name;
        this.orderDetails = orderDetails;
    }

    public void setCustomerId(CustomerId customerId){
        this.customerId = customerId;
    }

    public CustomerId getCustomerId(){
        return this.customerId;
    }

    public void setCompany(String company){
        this.company = company;
    }

    public String getCompany(){
        return this.company;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails){
        this.orderDetails = orderDetails;
    }

    public Set<OrderDetail> getOrderDetails(){
        return this.orderDetails;
    }

    public String toString(){
        String info = "";
        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("customerId",this.customerId.getCustomerId());
        jsonInfo.put("brandcode", this.customerId.getBrandcode());
        jsonInfo.put("company", this.getCompany());
        jsonInfo.put("name", this.getName());

        JSONArray orders = new JSONArray();
        if(this.orderDetails != null){
            this.orderDetails.forEach(order->{
                JSONObject orderInfo = new JSONObject();
                orderInfo.put("orderId-" + order.getOrderId() , order);
                orders.put(orderInfo);
            });
        }
        jsonInfo.put("products", orders);
        info = jsonInfo.toString();
        return info;

    }
}