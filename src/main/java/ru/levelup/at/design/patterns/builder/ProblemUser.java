package ru.levelup.at.design.patterns.builder;

public class ProblemUser {

    private String username;
    private String email;
    private Integer age;
    private String address;
    private String phone;

    public ProblemUser() {
    }

    public ProblemUser(String username, String email, Integer age, String address, String phone) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
