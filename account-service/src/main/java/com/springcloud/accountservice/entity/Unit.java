package com.springcloud.accountservice.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springcloud.accountservice.dto.Area;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("unit")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Unit {

    @Id
    private String unitName;

    private String phone;

    private String contact;

    private String address;

    private Area area;

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }
}