package com.kish.jpa.tutorial.dao.embedded.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="order_detail")
public class OrderDetail {

    @Id
    @Column(name="order_id")
    private String orderId;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "brandcode", referencedColumnName = "brandcode"),
            @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    })
    private Customer customer;

    private String product;

    public OrderDetail(){
    }

    public OrderDetail(String orderId, String product, Customer customer){
        this.orderId = orderId;
        this.product = product;
        this.customer = customer;
    }

    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public String getOrderId(){
        return this.orderId;
    }

    public void setCustomer(Customer customer){
        this.customer = customer;
    }

    public Customer getCustomer(){
        return this.customer;
    }

    public void setProductName(String product){
        this.product = product;
    }

    public String getProduct(){
        return this.product;
    }

    public String toString(){
        return String.format("['product': %s]", this.product);
    }
}