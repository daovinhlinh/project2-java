package com.project2.demo.services;

import com.project2.demo.dto.CitizenHomeDTO;
import com.project2.demo.entity.Citizen;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CitizenService {
    List<Citizen> getAllCitizen();

    Citizen findById(int id);

    Citizen add(CitizenHomeDTO citizen);

    Citizen update(CitizenHomeDTO citizen);

    Boolean delete(int id);

    List<Citizen> findCitizens(String fullname);
}
