package com.project2.demo.dao;

import com.project2.demo.entity.Citizen;
import com.project2.demo.entity.CitizenHome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenHomeRepository extends JpaRepository<CitizenHome, Integer> {
}
