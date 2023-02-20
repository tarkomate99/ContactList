package com.example.contactlist.Models;

public class Contact {

    private String name;
    private String email;
    private String address;
    private String imageUrl;

    public Contact() {
    }

    public Contact(String name, String email, String address, String imageUrl) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.imageUrl = imageUrl;
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
}
