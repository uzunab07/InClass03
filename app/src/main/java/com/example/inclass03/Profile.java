package com.example.inclass03;
//Authors
//Group 14
// Joseph Mauney and Khaled Mohamed Ali

import java.io.Serializable;

public class Profile implements Serializable {

   private String name,email,id,department;

    public Profile(String name, String email, String id, String department) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
