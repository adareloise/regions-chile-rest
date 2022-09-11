package com.adareloise.microservices.regions.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adareloise.microservices.regions.exception.global.ProvinceNotFoundException;
import com.adareloise.microservices.regions.model.Province;
import com.adareloise.microservices.regions.model.Region;
import com.adareloise.microservices.regions.model.dto.ProvinceDto;
import com.adareloise.microservices.regions.repository.IProvinceDao;
import com.adareloise.microservices.regions.services.IProvinceService;
import com.adareloise.microservices.regions.services.IRegionService;


@Service
@Transactional
public class ProvinceServiceImpl implements IProvinceService {

	@Autowired
	private IProvinceDao iProvince;
	
	@Autowired
	private IRegionService regionService;

	
	@Override
	public List<Province> findAll() throws ProvinceNotFoundException{
		List<Province> provinces = (List<Province>) iProvince.findAll();
		
		if(provinces.isEmpty()) {
			throw new ProvinceNotFoundException("No hay provincias agregadas");
		}
		return provinces;
	}

	@Override
	public ProvinceDto save(ProvinceDto dto, Integer idReg) {
		
		Region region = this.regionService.findOne(idReg);
		
		Province entity = new Province();
		
		if(dto.getId() != null) {
			entity.setId(dto.getId());
		}
		
		entity.setName(dto.getName());
		entity.setRegion(region);
		
		iProvince.save(entity);
		
		return dto;
	}

	@Override
	public ProvinceDto findOneDto(Integer id) throws ProvinceNotFoundException{
		Province entity = this.findById(id);
		ProvinceDto dto = new ProvinceDto();
			
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setCommunes(entity.getCommunes());
		
		return dto;
	}
	
	@Override
	public Province findById(Integer id) throws ProvinceNotFoundException{
		Province province = iProvince.findById(id).orElse(null);
		if (province == null )
			throw new ProvinceNotFoundException
				("La provincia ID: ".concat(id.toString().concat(" no fue encontrada")));
		return province;
	}

	@Override
	public ProvinceDto delete(Integer id) {
		ProvinceDto province = this.findOneDto(id);
		iProvince.deleteById(id);
		
		return province;
	}
}
