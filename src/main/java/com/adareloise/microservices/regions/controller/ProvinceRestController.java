package com.adareloise.microservices.regions.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adareloise.microservices.regions.model.Province;
import com.adareloise.microservices.regions.model.dto.ProvinceDto;
import com.adareloise.microservices.regions.services.IProvinceService;

@RestController
@RequestMapping(value = "/provinces", method = RequestMethod.GET)
public class ProvinceRestController {

	@Autowired
	private IProvinceService provinceService;

	/**
	 * Get list provinces.
	 *
	 * @return
	 */
	@GetMapping("/list")
	public ResponseEntity<?> listar() {
		Map<String, Object> response = new HashMap<>();
		List<Province> provinces = this.provinceService.findAll();

		response.put("msj", "Consulta existosa");
		response.put("provinces", provinces);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Get province by id.
	 *
	 * @param id
	 * @return
	 */
	@GetMapping("/show/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id) {
		Province province = provinceService.findOne(id);

		Map<String, Object> response = new HashMap<>();

		response.put("msj", "Consulta existosa");
		response.put("province", province);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	/**
	 * Add new province.
	 *
	 * @param item
	 * @param id   region
	 * @return
	 */
	@PostMapping("/create/{idReg}")
	public ResponseEntity<?> create(@PathVariable Integer idReg, @RequestBody ProvinceDto item) {

		Map<String, Object> response = new HashMap<>();
		
		try {
			ProvinceDto commune = this.provinceService.save(item, idReg);
			
			response.put("msj", "Comuna creada");
			response.put("commune", commune);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		} catch (DataAccessException e) {
			response.put("msj", "Error de insercion");
			response.put("error", e);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Add new provinces for region .
	 *
	 * @param id   region
	 * @param list items
	 * @return
	 */
	@PostMapping("/create/list/{id}")
	public ResponseEntity<?> create(@PathVariable Integer idReg, @RequestBody List<ProvinceDto> items) {

		Map<String, Object> response = new HashMap<>();
		
		try {

			List<ProvinceDto> provinces = new ArrayList<>();
			
			for (ProvinceDto item : items) {
				ProvinceDto province = new ProvinceDto();
				province.setName(item.getName());
				provinces.add(this.provinceService.save(province, idReg));
			}
			
			response.put("msj", "Comunas creadas");
			response.put("communes", provinces);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		} catch (DataAccessException e) {
			response.put("msj", "Error de insercion");
			response.put("error", e);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
	}

	/**
	 * Update province by id.
	 *
	 * @param id
	 * @param item
	 * @return
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer idReg, @RequestBody ProvinceDto item) {
		
		Map<String, Object> response = new HashMap<>();
		
		try {
			ProvinceDto commune = this.provinceService.save(item, idReg);
			
			response.put("msj", "Comuna creada");
			response.put("commune", commune);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		} catch (DataAccessException e) {
			response.put("msj", "Error de insercion");
			response.put("error", e);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Delete province by id.
	 *
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		ProvinceDto province = provinceService.delete(id);
		Map<String, Object> response = new HashMap<>();

		response.put("msj", "Provincia eliminada");
		response.put("province", province);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
