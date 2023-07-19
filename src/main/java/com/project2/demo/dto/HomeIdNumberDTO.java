package com.project2.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project2.demo.entity.Citizen;
import com.project2.demo.entity.Home;

import java.util.List;

public class HomeIdNumberDTO {
    @JsonProperty("home")
    private Home home;

    @JsonProperty("idNumber")
    private Integer idNumber;

    public HomeIdNumberDTO(Home home, Integer idNumber) {
        this.home= home;
        this.idNumber = idNumber;
    }

    public Home getHome() {
        return this.home;
    }
    public Integer getIdNumber() {
        return this.idNumber;
    }
}
