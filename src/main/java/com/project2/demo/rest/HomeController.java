package com.project2.demo.rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.project2.demo.dto.HomeDTO;
import com.project2.demo.dto.HomeIdNumberDTO;
import com.project2.demo.entity.Citizen;
import com.project2.demo.entity.Home;
import com.project2.demo.services.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController()
@RequestMapping("/api/home")
public class HomeController {
    private HomeService homeService;

    @Autowired
    public HomeController(HomeService service) {
        homeService = service;
    }

    @GetMapping("/getAll")
        public List<Home> getAll() {
        return homeService.getAllHome();
    }

    @PostMapping("/add")
    public Home addHome(@RequestBody ObjectNode node){
        String address = node.get("address").asText();
        Integer citizenIdNumber = node.get("citizenIdNumber").asInt();
        System.out.println(citizenIdNumber);
        Home newHome = new Home(address);
        return homeService.add(newHome,citizenIdNumber);
    }

    @PostMapping("/addMember")
    public Citizen addHomeMember(@RequestBody ObjectNode node) {
        System.out.println(node);
        Integer homeId = node.get("id").asInt();
        Integer citizenId = node.get("citizenIdNumber").asInt();
        System.out.println(homeId);
        System.out.println(citizenId);
        return homeService.addHomeMember(homeId, citizenId);

    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<HomeDTO> getHome(@PathVariable(name="id") Integer userId) {
        return ResponseEntity.ok().body(homeService.findById(userId));
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCitizen(@PathVariable(name="id") Integer userId) {
        System.out.println(userId);
        return homeService.delete(userId);
    }

    @PostMapping("/{id}/update")
    public Home updateCitizen(@PathVariable(name="id") Integer homeId, @RequestBody ObjectNode body) {
        return homeService.update(homeId, body);
    }
}
