package com.adareloise.microservices.regions.services;

import java.util.List;

import com.adareloise.microservices.regions.model.Province;
import com.adareloise.microservices.regions.model.dto.ProvinceDto;


public interface IProvinceService {
	
	public List<Province> findAll();
	
	public ProvinceDto save(ProvinceDto dto, Integer idReg);
	
	public Province findOne(Integer id);
	
	public ProvinceDto findOneDto(Integer id);
		
	public ProvinceDto delete(Integer id);
}
