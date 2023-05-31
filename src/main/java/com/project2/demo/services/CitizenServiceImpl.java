package com.project2.demo.services;

import com.project2.demo.dao.CitizenRepository;
import com.project2.demo.entity.Citizen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CitizenServiceImpl implements CitizenService{
    private CitizenRepository citizenRepository;

    @Autowired
    public CitizenServiceImpl(CitizenRepository citizenRepository) {
        this.citizenRepository = citizenRepository;
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
    public Citizen save(Citizen citizen) {
        return citizenRepository.save(citizen);
    }

    @Override
    public Citizen update(Citizen theCitizen) {
        Citizen citizen = findById(theCitizen.getId());

        if (citizen != null) {
            citizen.setFullname(theCitizen.getFullname());
            citizen.setAddress(theCitizen.getAddress());
            citizen.setEmail(theCitizen.getEmail());

            citizenRepository.save(citizen);
        } else {
            throw new RuntimeException("Did not find citizen id - " + theCitizen.getId());
        }

        return citizen;
    }
}
