package com.adareloise.microservices.regions.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adareloise.microservices.regions.exception.global.CommuneNotFoundException;
import com.adareloise.microservices.regions.model.Commune;
import com.adareloise.microservices.regions.model.Province;
import com.adareloise.microservices.regions.model.dto.CommuneDto;
import com.adareloise.microservices.regions.repository.ICommuneDao;
import com.adareloise.microservices.regions.services.ICommuneService;
import com.adareloise.microservices.regions.services.IProvinceService;

@Service
public class CommuneServiceImpl implements ICommuneService {

	@Autowired
	private ICommuneDao iCommune;
	
	@Autowired
	private IProvinceService provinceService;

	
	@Override
	@Transactional(readOnly = true)
	public List<Commune> findAll() throws CommuneNotFoundException{
		List<Commune> communes = (List<Commune>) iCommune.findAll();
		
		if(communes.isEmpty()) {
			throw new CommuneNotFoundException("No hay comunas agregadas");
		}
		return communes;
	}

	@Override
	@Transactional()
	public CommuneDto save(CommuneDto dto, Integer IdProv) {
		
		Province province = this.provinceService.findOne(IdProv);
		dto.setProvince(province);
		
		Commune entity = new Commune();
		
		if(dto.getId() != null) {
			entity.setId(dto.getId());
		}
		
		entity.setName(dto.getName());
		entity.setProvince(dto.getProvince());
		
		iCommune.save(entity);
		
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	public CommuneDto findOne(Integer id) throws CommuneNotFoundException{
		
		Commune entity = iCommune.findById(id).orElse(null);
		CommuneDto dto = new CommuneDto();
		
		if (entity == null )
			throw new CommuneNotFoundException
				("La commune ID: ".concat(id.toString().concat(" no fue encontrado")));
		
		dto.setId(entity.getId());
		dto.setName(entity.getName());
		dto.setProvince(entity.getProvince());
		
		return dto;
	}

	@Override
	@Transactional()
	public CommuneDto delete(Integer id) {
		CommuneDto commune  = this.findOne(id);
		iCommune.deleteById(id);
		return commune;
	}

}
