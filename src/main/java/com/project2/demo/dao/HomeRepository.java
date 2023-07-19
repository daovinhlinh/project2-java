package com.project2.demo.dao;

import com.project2.demo.entity.Citizen;
import com.project2.demo.entity.Home;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeRepository extends JpaRepository<Home, Integer> {
}
