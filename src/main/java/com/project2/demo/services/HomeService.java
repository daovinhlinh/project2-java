package com.project2.demo.services;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project2.demo.dto.HomeDTO;
import com.project2.demo.entity.Citizen;
import com.project2.demo.entity.Home;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface HomeService {
    List<Home> getAllHome();

    HomeDTO findById(int id);

    Home add(Home home, Integer citienIdNumber);

    Home update(Integer homeId, ObjectNode body);

    Boolean delete(Integer id);

    Citizen addHomeMember(Integer id, Integer citizenIdNumber);
}
