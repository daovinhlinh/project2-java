package com.project2.demo.rest;

import com.project2.demo.dto.CitizenHomeDTO;
import com.project2.demo.entity.Citizen;
import com.project2.demo.services.CitizenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @GetMapping("/{id}")
    public Citizen getCitizen(@PathVariable(name="id") Integer userId) {
        return citizenService.findById(userId);
    }

    @PostMapping("/add")
    public Citizen addCitizen(@RequestBody CitizenHomeDTO citizen){
        return citizenService.add(citizen);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCitizen(@PathVariable(name="id") Integer userId) {
        return citizenService.delete(userId);
    }

    @PostMapping("/update")
    public Citizen updateCitizen(@RequestBody CitizenHomeDTO citizenHomeDTO) {
        return citizenService.update(citizenHomeDTO);
    }

    @GetMapping("/find/{name}")
    public List<Citizen> findCitizensByName(@PathVariable(name="name") String name) {
        return citizenService.findCitizens(name);
    }
}
