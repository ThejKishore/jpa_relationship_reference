package com.kish.jpa.tutorial.dao.onetomany.model;

import org.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id")
    private Company company;

    public Product(){
    }

    public Product(String name, Company company){
        this.name = name;
        this.company = company;
    }

    // name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // products
    public void setCompany(Company company){
        this.company = company;
    }

    public Company getCompany(){
        return this.company;
    }

   public String toString(){
        String info = "";

        JSONObject jsonInfo = new JSONObject();
        jsonInfo.put("name",this.name);

        JSONObject companyObj = new JSONObject();
        companyObj.put("name", this.company.getName());
        jsonInfo.put("company", companyObj);

        info = jsonInfo.toString();
        return info;
    }
}
