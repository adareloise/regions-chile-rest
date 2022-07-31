package com.adareloise.microservices.regions.services;

import java.util.List;

import com.adareloise.microservices.regions.model.Region;
import com.adareloise.microservices.regions.model.dto.RegionDto;

public interface IRegionService {
	
	public List<Region> findAll();
	
	public RegionDto save(RegionDto dto);
	
	public Region findOne(Integer id);
	
	public RegionDto findOneDto(Integer id);
		
	public RegionDto delete(Integer id);
}
