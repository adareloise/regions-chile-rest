package com.adareloise.microservices.regions.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.adareloise.microservices.regions.model.Commune;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProvinceDto {
	
	private Integer id;
	private String name;
	private List<Commune> communes = new ArrayList<>();
	private RegionDto region;

}
