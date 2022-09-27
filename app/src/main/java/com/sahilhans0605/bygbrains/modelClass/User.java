package com.sahilhans0605.bygbrains.modelClass;

public class User {
    private String name, age, gender, number, uid, UniqueUserId, password;

    public User(String name, String age, String gender, String number, String uid, String uniqueUserId, String password) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.number = number;
        this.uid = uid;
        UniqueUserId = uniqueUserId;
        this.password = password;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUniqueUserId() {
        return UniqueUserId;
    }

    public void setUniqueUserId(String uniqueUserId) {
        UniqueUserId = uniqueUserId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}