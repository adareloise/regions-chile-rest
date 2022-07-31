package com.adareloise.microservices.regions.services;

import java.util.List;

import com.adareloise.microservices.regions.model.Commune;
import com.adareloise.microservices.regions.model.dto.CommuneDto;


public interface ICommuneService {
	
	public List<Commune> findAll();
	
	public CommuneDto save(CommuneDto dto, Integer idProv);
	
	public CommuneDto findOne(Integer id);
		
	public CommuneDto delete(Integer id);
}
