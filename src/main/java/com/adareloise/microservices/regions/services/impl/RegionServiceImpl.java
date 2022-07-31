package com.adareloise.microservices.regions.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adareloise.microservices.regions.exception.global.RegionNotFoundException;
import com.adareloise.microservices.regions.model.Province;
import com.adareloise.microservices.regions.model.Region;
import com.adareloise.microservices.regions.model.dto.RegionDto;
import com.adareloise.microservices.regions.repository.IRegionDao;
import com.adareloise.microservices.regions.services.IRegionService;

@Service
@Transactional
public class RegionServiceImpl implements IRegionService {

	@Autowired
	private IRegionDao iRegion;
	
	@Override
	public List<Region> findAll() throws RegionNotFoundException{
		List<Region> regions = (List<Region>) iRegion.findAll();
		
		if(regions.isEmpty()) {
			throw new RegionNotFoundException("No hay regiones agregadas");
		}
		return regions;
	}

	@Override
	public RegionDto save(RegionDto dto) {
	
		Region entity = new Region();
		
		if(dto.getId() != null) {
			entity.setId(dto.getId());
		}
		
		entity.setName(dto.getName());
		
		iRegion.save(entity);
		
		return dto;
	}

	@Override
	public Region findOne(Integer id) throws RegionNotFoundException{
		Region region = iRegion.findById(id).orElse(null);
		if (region == null )
			throw new RegionNotFoundException
				("La region ID: ".concat(id.toString().concat(" no fue encontrada")));
		return region;
	}
	
	@Override
	public RegionDto findOneDto(Integer id) throws RegionNotFoundException{
		Region entity = iRegion.findById(id).orElse(null);
		RegionDto dto = new RegionDto();
		
		if (entity == null )
			throw new RegionNotFoundException
				("La region ID: ".concat(id.toString().concat(" no fue encontrada")));
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setProvinces(entity.getProvinces());
		
		return dto;
	}

	@Override
	public RegionDto delete(Integer id) {
		RegionDto region = this.findOneDto(id);
		iRegion.deleteById(id);
		return region;
	}
}
