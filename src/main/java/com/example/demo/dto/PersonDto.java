package com.example.demo.dto;

public class PersonDto {
    private Integer idUser;
    private String nicknameUser;
    private String name;
    private String secondName;
    private String lastName;
    private String secondLastName;
    private String mail;
    private String password;
    private String urlImage;
    private String nameImage;

    public PersonDto() {
    }

    public PersonDto(Integer idUser, String nicknameUser, String name, String secondName, String lastName, String secondLastName, String mail, String password, String urlImage, String nameImage) {
        this.idUser = idUser;
        this.nicknameUser = nicknameUser;
        this.name = name;
        this.secondName = secondName;
        this.lastName = lastName;
        this.secondLastName = secondLastName;
        this.mail = mail;
        this.password = password;
        this.urlImage = urlImage;
        this.nameImage = nameImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getNameImage() {
        return nameImage;
    }

    public void setNameImage(String nameImage) {
        this.nameImage = nameImage;
    }

    public String getNicknameUser() {
        return nicknameUser;
    }

    public void setNicknameUser(String nicknameUser) {
        this.nicknameUser = nicknameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
}

