package com.project2.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name="citizen")
public class Citizen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "dob")
    private String dob;

    @Column(name = "gender")
    private String gender;

    @Column(name = "idnumber")
    private Integer idnumber;

    @Column(name = "phone")
    private String phone;

    @Column(name = "image")
    private String image;

//    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name = "home_id")
    private Home home;

    public Citizen() {

    }

    public Citizen(String fullname, String email, String dob, Integer idnumber, String gender, String phone, String image) {
        this.fullname = fullname;
        this.email = email;
        this.dob = dob;
        this.idnumber = idnumber;
        this.gender = gender;
        this.phone = phone;
        this.image = image;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullname;
    }

    public void setFullName(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getIdNumber() {
        return idnumber;
    }

    public void setIdNumber(Integer idnumber) {
        this.idnumber = idnumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Home getHome() {
        return home;
    }

    public void setHome(Home home) {
        this.home = home;
    }

    // define toString
    @Override
    public String toString() {
        return "Citizen {" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                                ", dob='" + dob + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
