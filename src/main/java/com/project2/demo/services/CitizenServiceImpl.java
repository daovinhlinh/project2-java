package com.project2.demo.services;

import com.project2.demo.dao.CitizenRepository;
import com.project2.demo.dao.HomeRepository;
import com.project2.demo.dto.CitizenHomeDTO;
import com.project2.demo.entity.Citizen;
import com.project2.demo.entity.Home;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenServiceImpl implements CitizenService{
    private CitizenRepository citizenRepository;
    private HomeRepository homeRepository;

    @Autowired
    public CitizenServiceImpl(CitizenRepository citizenRepository, HomeRepository homeRepository) {
        this.citizenRepository = citizenRepository;
        this.homeRepository = homeRepository;
    }

    @Override
    public List<Citizen> getAllCitizen() {
        return citizenRepository.findAll();
    }

    @Override
    public Citizen findById(int id) {
        Optional<Citizen> result = citizenRepository.findById(id);

        Citizen citizen = null;

        if (result.isPresent()) {
            citizen = result.get();
        } else {
            throw new RuntimeException("Did not find citizen id - " + id);
        }

        return citizen;
    }



    @Override
    public Citizen add(@RequestBody CitizenHomeDTO citizenHomeDTO) {
        Citizen citizenData = citizenHomeDTO.getCitizen();
        Integer homeId = citizenHomeDTO.getHomeId();

        Home home = homeRepository.findById(homeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid family ID: " + homeId));
        System.out.println("home"+ home);
        Citizen newCitizen = new Citizen();
    if (home != null) {
        newCitizen.setFullName(citizenData.getFullName());
        newCitizen.setDob(citizenData.getDob());
        newCitizen.setImage(citizenData.getImage());
        newCitizen.setPhone(citizenData.getPhone());
        newCitizen.setGender(citizenData.getGender());
        newCitizen.setIdNumber(citizenData.getIdNumber());
        newCitizen.setEmail(citizenData.getEmail());
        newCitizen.setHome(home);

        Citizen savedCitizen =  citizenRepository.save(newCitizen);
        System.out.println(savedCitizen);
        return savedCitizen;

    } else {
        return null;
    }

    }

    @Override
    public Boolean delete(int id) {
        try {
            citizenRepository.deleteById(id);
            return true;
        }catch (Exception e) {
        return false;
        }
    }

    @Override
    public Citizen update(CitizenHomeDTO citizenHomeDTO) {
        Citizen citizenData = citizenHomeDTO.getCitizen();
        Integer homeId = citizenHomeDTO.getHomeId();

        Citizen citizen = findById(citizenData.getId());

        Home home = homeRepository.findById(homeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid family ID: " + homeId));

        if (citizen != null) {
            citizen.setFullName(citizenData.getFullName());
            citizen.setEmail(citizenData.getEmail());
            citizen.setDob(citizenData.getDob());
            citizen.setIdNumber(citizenData.getIdNumber());
            citizen.setGender(citizenData.getGender());
            citizen.setPhone(citizenData.getPhone());
            citizen.setImage(citizenData.getImage());
            citizen.setHome(home);
            citizenRepository.save(citizen);
        } else {
            throw new RuntimeException("Did not find citizen id - " + citizen.getId());
        }

        return citizen;
    }

    @Override
    public List<Citizen> findCitizens(String name) {
        List<Citizen> citizens = citizenRepository.findCitizenByFullnameContainingIgnoreCase(name);
        return citizens;
    }
}
