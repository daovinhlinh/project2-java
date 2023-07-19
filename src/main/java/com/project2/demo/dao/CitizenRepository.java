package com.project2.demo.dao;

import com.project2.demo.entity.Citizen;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Integer> {
    List<Citizen> findCitizenByFullnameContainingIgnoreCase(String fullname);
    List<Citizen> findAllByHomeId(Integer homeId);
    Citizen findCitizenByIdnumber(Integer idNumber);
}
