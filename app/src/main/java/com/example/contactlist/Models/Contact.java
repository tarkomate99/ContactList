package com.example.contactlist.Models;

public class Contact {

    private Integer id;
    private String name;
    private String email;
    private String address;
    private String imageUrl;
    private String mobile;
    private String work;

    public Contact() {
    }

    public Contact(Integer id,String name, String email, String address, String imageUrl, String mobile, String work) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.imageUrl = imageUrl;
        this.mobile = mobile;
        this.work = work;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
