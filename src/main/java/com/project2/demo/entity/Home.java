package com.project2.demo.entity;

import com.fasterxml.jackson.annotation.*;
import com.project2.demo.type.CustomStringArrayType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Table(name="home")
public class Home {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;


    @Column(name = "address")
    private String address;

    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @OneToOne()
    @JoinColumn(name = "owner_id")
    private Citizen owner;

    @OneToMany()
    @JoinColumn(name="home_id", referencedColumnName = "id")
    private List<Citizen> member;

    public Home() {

    }


    public Home(String address) {
        this.address = address;
//        this.owner = owner;
    }

    public Home(Home home) {
        this.address = home.getAddress();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Citizen getOwner() {
        return owner;
    }

    public void setOwner(Citizen owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    // define toString
    @Override
    public String toString() {
        return "Homes {" +
                "id=" + id +
                ", address='" + address + '\'';
    }
}
