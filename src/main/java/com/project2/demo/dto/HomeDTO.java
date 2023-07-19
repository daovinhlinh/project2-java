package com.project2.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project2.demo.entity.Citizen;
import com.project2.demo.entity.Home;

import java.util.List;

public class HomeDTO {
    @JsonProperty("home")
    private Home home;

    @JsonProperty("members")
    private List<Citizen> members;

    public HomeDTO(Home home, List<Citizen> members) {
        this.home= home;
        this.members = members;
    }

    Home getHome() {
        return this.home;
    }

    void setHome(Home home) {
        this.home = home;
    }

    List<Citizen> getMembers() {
        return this.members;
    }

    void setMembers(List<Citizen> citizens) {
        this.members = citizens;
    }
}
