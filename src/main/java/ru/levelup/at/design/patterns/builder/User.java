package ru.levelup.at.design.patterns.builder;

public class User {

    private final String username;
    private final String email;
    private final Integer age;
    private final String address;
    private final String phone;

    private User(String username, String email, Integer age, String address, String phone) {
        this.username = username;
        this.email = email;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "User{"
            + "username='" + username + '\''
            + ", email='" + email + '\''
            + ", age=" + age
            + ", address='" + address + '\''
            + ", phone='" + phone + '\''
            + '}';
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private String username;
        private String email;
        private Integer age;
        private String address;
        private String phone;

        public UserBuilder() {
        }

        public UserBuilder username(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public User build() {
            return new User(username, email, age, address, phone);
        }
    }
}
