package com.adareloise.microservices.regions.model.dto;

import com.adareloise.microservices.regions.model.Province;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CommuneDto {

	private Integer id;
	private String name;
	private Province province;

}
