package com.adareloise.microservices.regions.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adareloise.microservices.regions.model.Region;
import com.adareloise.microservices.regions.model.dto.RegionDto;
import com.adareloise.microservices.regions.services.IRegionService;

@RestController

@CrossOrigin(origins = {"http://localhost:8081", "http://localhost:8082"})

@RequestMapping(value = "/regions", method = RequestMethod.GET)

public class RegionRestController {

	@Autowired
	private IRegionService regionService;
	
	  /**
     * Get list regiones.
     *
     * @return
     */
	@GetMapping("/list")
	public ResponseEntity<?> listar(){
		Map<String, Object> response = new HashMap<>();
		
		List<Region> regions= this.regionService.findAll();
						
		response.put("msj", "Consulta existosa");
		response.put("regions", regions);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}	

	 /**
     * Get region by id.
     *
     * @param id
     * @return
     */
	@GetMapping("/show/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id) { 
		RegionDto region = regionService.findOneDto(id);
		
		Map<String, Object> response = new HashMap<>();

		response.put("msg", "Consulta existosa");
		response.put("region", region);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	 /**
    * Add new region.
    *
    * @param item
    * @return
    */
	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody RegionDto item) {
		
		Map<String, Object> response = new HashMap<>();

		try {
			
			RegionDto region = this.regionService.save(item);
			
			response.put("msg", "Comuna creada");
			response.put("region", region);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		} catch (DataAccessException e) {
			response.put("msg", "Error de insercion");
			response.put("error", e);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	 /**
     * Update region by id.
     *
     * @param id
     * @param item
     * @return
     */
	@PutMapping("/update")
	public ResponseEntity<?> update(@RequestBody RegionDto item) {

		Map<String, Object> response = new HashMap<>();

		try {
			
			RegionDto region = this.regionService.save(item);
			
			response.put("msg", "Comuna creada");
			response.put("region", region);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		} catch (DataAccessException e) {
			response.put("msg", "Error de insercion");
			response.put("error", e);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	 /**
     * Delete region by id.
     *
     * @param id
     * @return
     */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {		
		RegionDto region = regionService.delete(id);
		Map<String, Object> response = new HashMap<>();
		
		response.put("msg", "Region eliminado");
		response.put("region", region);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
