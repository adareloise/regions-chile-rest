package com.adareloise.microservices.regions.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.adareloise.microservices.regions.model.Commune;
import com.adareloise.microservices.regions.model.Region;

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
	private Region region;
	private List<Commune> communes = new ArrayList<>();

}
