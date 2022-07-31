package com.adareloise.microservices.regions.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adareloise.microservices.regions.model.Commune;



public interface ICommuneDao extends JpaRepository<Commune, Integer>{

}
