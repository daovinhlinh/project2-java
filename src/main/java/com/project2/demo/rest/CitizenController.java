package com.project2.demo.rest;

import com.project2.demo.entity.Citizen;
import com.project2.demo.services.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/api/citizen")
public class CitizenController {
    private CitizenService citizenService;

    @Autowired
    public CitizenController(CitizenService service) {
        citizenService = service;
    }

    @GetMapping("/getAll")
        public List<Citizen> getAll() {
        return citizenService.getAllCitizen();
    }
}
