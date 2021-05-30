package com.example.demo.dto;

public class RegisterUserDto {
    private String username;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String urlPhoto;
    private String role;

    public RegisterUserDto() {
    }

    public RegisterUserDto(String username, String name, String surname, String role, String email, String password, String urlPhoto) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.role = role;
        this.email = email;
        this.password = password;
        this.urlPhoto = urlPhoto;
    }

    @Override
    public String toString() {
        return "RegisterUserDto{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }
}
