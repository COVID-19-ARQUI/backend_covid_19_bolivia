package com.example.demo.dto;

public class RegisterUserDto {
    private String nicknameUser;
    private String name;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String email;
    private String password;
    private String urlPhoto;

    public RegisterUserDto() {

    }

    public RegisterUserDto(String nicknameUser, String name, String secondName, String lastName, String secondLastName, String email, String password, String urlPhoto) {
        this.nicknameUser = nicknameUser;
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.email = email;
        this.password = password;
        this.urlPhoto = urlPhoto;
    }

    @Override
    public String toString() {
        return "RegisterUserDto{" +
                "nicknameUser='" + nicknameUser + '\'' +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", secondLastName='" + secondLastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", urlPhoto='" + urlPhoto + '\'' +
                '}';
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getNicknameUser() {
        return nicknameUser;
    }

    public void setNicknameUser(String nicknameUser) {
        this.nicknameUser = nicknameUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
