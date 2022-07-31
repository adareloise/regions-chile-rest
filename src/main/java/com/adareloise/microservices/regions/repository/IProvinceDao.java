package com.adareloise.microservices.regions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adareloise.microservices.regions.model.Province;


public interface IProvinceDao extends JpaRepository<Province, Integer>{

}
