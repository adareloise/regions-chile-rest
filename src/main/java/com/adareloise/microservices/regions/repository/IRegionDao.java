package com.adareloise.microservices.regions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adareloise.microservices.regions.model.Region;


public interface IRegionDao extends JpaRepository<Region, Integer>{

}
