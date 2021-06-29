package com.jsonplaceholder.model;

public class User {
    private final long id;
    private final  String name;
    private final  String userName;
    private final  String email;
    private final Address address;
    private final  String phone;
    private final  String website;
    private final Company company;

    public User(long id, String name, String userName, String email, Address address, String phone, String website, Company company) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.company = company;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
