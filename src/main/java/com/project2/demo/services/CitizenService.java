package com.project2.demo.services;

import com.project2.demo.entity.Citizen;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CitizenService {
    List<Citizen> getAllCitizen();

    Citizen findById(int id);

    Citizen save(Citizen citizen);

    Citizen update(Citizen citizen);
}
