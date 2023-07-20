package com.project2.demo.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project2.demo.dao.CitizenRepository;
import com.project2.demo.dao.HomeRepository;
import com.project2.demo.dto.HomeDTO;
import com.project2.demo.entity.Citizen;
import com.project2.demo.entity.Home;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HomeServiceImpl implements HomeService{
    private HomeRepository homeRepository;
    private CitizenRepository citizenRepository;
    private EntityManager entityManager;

    @Autowired
    public HomeServiceImpl(HomeRepository homeRepository, CitizenRepository citizenRepository, EntityManager entityManager) {
        this.homeRepository = homeRepository;
        this.citizenRepository  = citizenRepository;
        this.entityManager = entityManager;
    }

    @Override
    public List<Home> getAllHome() {
        return homeRepository.findAll();
    }

    @Override
    public HomeDTO findById(int id) {
        Home result =  homeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid family ID: " + id));
        List<Citizen> citizens = citizenRepository.findAllByHomeId(id);
        System.out.println(citizens);

        if (result != null && citizens != null) {
            HomeDTO homeData = new HomeDTO(result, citizens);
            return homeData;
        } else {
            throw new RuntimeException("Did not find home id - " + id);
        }
    }

    @Override
    public Home add(Home home, Integer citizenIdNumber) {
        Home newhome = new Home(home);
        Citizen citizen = citizenRepository.findCitizenByIdnumber(citizenIdNumber);
        citizen.setHome(newhome);
        newhome.setOwner(citizen);
        return homeRepository.save(newhome);
    }


    @Override
    public Boolean delete(Integer id) {
        try {
            homeRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            System.out.println(e);
        return false;
        }
    }

    @Override
    public Home update(Integer homeId, ObjectNode body) {
        Home homeResponse =  homeRepository.findById(homeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid family ID: "));
        String address = body.get("address").asText();
        JsonNode idNumber = body.get("idNumber");

        Citizen citizen = citizenRepository.findCitizenByIdnumber(idNumber.asInt());
        System.out.println(citizen);
        if (homeResponse != null) {
            homeResponse.setAddress(address);
            if (citizen != null) {
                if (homeResponse.getOwner() != null) {
                    Citizen currentOwner = citizenRepository.findById(homeResponse.getOwner().getId()).orElseThrow(() -> new IllegalArgumentException("invalid current owner"));
                        currentOwner.setHome(null);
                }

                homeResponse.setOwner(citizen);
                citizen.setHome(homeResponse);
                citizenRepository.save(citizen);
            }
            homeRepository.save(homeResponse);
        } else {
            throw new RuntimeException("Did not find citizen id - " + homeId);
        }

        return homeResponse;
    }

    @Override
    public Citizen addHomeMember(Integer homeId, Integer citizenIdNumber) {
        Home home = homeRepository.findById(homeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid family ID: " + homeId));

        Citizen citizen = citizenRepository.findCitizenByIdnumber(citizenIdNumber);
        citizen.setHome(home);
//        home.setOwner(citizen);
        homeRepository.save(home);
        return citizenRepository.save(citizen);
    }
}
