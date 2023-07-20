package com.project2.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="citizen_home")
public class CitizenHome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="home_id")
    private Integer homeId;

    @Column(name="citizen_id")
    private Integer citizenId;

    public CitizenHome() {

    }
    public CitizenHome(Integer homeId, Integer citizenId) {
        this.homeId = homeId;
        this.citizenId = citizenId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getHomeId() {
        return homeId;
    }

    public void setHomeId(Integer homeId) {
        this.homeId = homeId;
    }

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
    }
}
