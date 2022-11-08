package com.webshoppe.ecommerce.entity;

import java.math.BigDecimal;

public class Flower {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    
    public Flower() {
    }

    public Flower(String id, String name, String description, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    public int hashCode() {
        return this.id.hashCode() * 31;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Flower)) {
            return false;
        }
        Flower otherFlower = (Flower)obj;
        return this.id.equals(otherFlower.getId()) && this.name.equals(otherFlower.getName())
               && this.description.equals(otherFlower.getDescription())
               && this.price.equals(otherFlower.getPrice());
    }
    

}
