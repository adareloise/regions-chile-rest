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

import com.adareloise.microservices.regions.model.Commune;
import com.adareloise.microservices.regions.model.dto.CommuneDto;
import com.adareloise.microservices.regions.services.ICommuneService;

@RestController
@RequestMapping(value = "/communes", method = RequestMethod.GET)
public class CommuneRestController {

	@Autowired
	private ICommuneService communeService;
	
	  /**
     * Get list communes.
     *
     * @return
     */
	@GetMapping("/list")
	public ResponseEntity<?> listar(){
		Map<String, Object> response = new HashMap<>();
		List<Commune> communes = this.communeService.findAll();
						
		response.put("msj", "Consulta existosa");
		response.put("communes", communes);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}	


	 /**
     * Get commune by id.
     *
     * @param id
     * @return
     */
	@GetMapping("/show/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id) { 
		CommuneDto commune = communeService.findOne(id);
		
		Map<String, Object> response = new HashMap<>();

		response.put("msj", "Consulta existosa");
		response.put("commune", commune);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	 /**
    * Add new commune.
    *
    * @param item
    * @param id province
    * @return
    */
	@PostMapping("/create/{idProv}")
	public ResponseEntity<?> create(@PathVariable Integer idProv, @RequestBody CommuneDto item) {
		
		Map<String, Object> response = new HashMap<>();

		try {
			
			CommuneDto commune = this.communeService.save(item, idProv);
			
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
	 * Add news communes in provinces.
	 *
	 * @param id province
	 * @param list items communes
	 * @return
	 */
	@PostMapping("/create/list/{idProv}")
	public ResponseEntity<?> create(@PathVariable Integer idProv, @RequestBody List<CommuneDto> items) {
		
		Map<String, Object> response = new HashMap<>();

		try {

			List<CommuneDto> communes = new ArrayList<>();
			
			for (CommuneDto item : items) {
				CommuneDto commune = new CommuneDto();
				commune.setName(item.getName());
				communes.add(this.communeService.save(commune, idProv));
			}
			
			response.put("msj", "Comunas creadas");
			response.put("communes", communes);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
		} catch (DataAccessException e) {
			response.put("msj", "Error de insercion");
			response.put("error", e);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}

	 /**
     * Update commune by id.
     *
     * @param id
     * @param item
     * @return
     */
	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@RequestBody CommuneDto item, @PathVariable Integer idProv) {

		Map<String, Object> response = new HashMap<>();
		
		try {
			
			CommuneDto commune = this.communeService.save(item, idProv);
			
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
     * Delete commune by id.
     *
     * @param id
     * @return
     */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {		
		CommuneDto commune = communeService.delete(id);
		Map<String, Object> response = new HashMap<>();
		
		response.put("msj", "Comuna eliminada");
		response.put("commune", commune);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
}
