package com.project2.demo.dto;

import com.project2.demo.entity.Citizen;
import com.project2.demo.entity.Home;

import java.util.List;

public class CitizenData {
    private Citizen citizen;
    private String homeAddress;
    public CitizenData(Citizen citizen, String homeAddress) {
        this.citizen= citizen;
        this.homeAddress = homeAddress;
    }

}
