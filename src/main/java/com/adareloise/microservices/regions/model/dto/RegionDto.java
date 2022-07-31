package com.adareloise.microservices.regions.model.dto;

import java.util.ArrayList;
import java.util.List;

import com.adareloise.microservices.regions.model.Province;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class RegionDto {

	private Integer id;
	private String name;
	private List<Province> provinces = new ArrayList<>();

}
