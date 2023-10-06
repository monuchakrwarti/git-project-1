package com.market_app_1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market_app_1.dto.LeadDto;
import com.market_app_1.entity.Lead;
import com.market_app_1.repository.LeadRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/leads") //http://localhost:8080/api/leads
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	
	//case 1:
	/*@PostMapping
	public void saveData(@RequestBody Lead lead) {
		leadRepo.save(lead);
	}
	*/
	//case 2:
	@PostMapping
	public ResponseEntity<Lead> saveData(@RequestBody Lead lead) {
		Lead save = leadRepo.save(lead);
		return new ResponseEntity<Lead>(save, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Lead> getLead(){
		List<Lead> findAll = leadRepo.findAll();
		return findAll;
	}
	
	//case 1:	
	//http://localhost:8080/api/leads?id=1
	//query parameter
	
	/*@PutMapping
	public void updateLead(@RequestParam("id")long id, @RequestBody LeadDto dto) {
		Optional<Lead> findById = leadRepo.findById(id);
		
		Lead lead = findById.get();
		lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		
		leadRepo.save(lead);
		
	}*/
	
	//case 2:
	@PutMapping
	public ResponseEntity<Lead> updateLead(@RequestParam("id")long id, @RequestBody LeadDto dto) {
		Optional<Lead> findById = leadRepo.findById(id);
		
		Lead lead = findById.get();
		lead.setFirstName(dto.getFirstName());
		lead.setLastName(dto.getLastName());
		lead.setEmail(dto.getEmail());
		lead.setMobile(dto.getMobile());
		
		Lead updateLead = leadRepo.save(lead);
		
		return new ResponseEntity<Lead>(updateLead, HttpStatus.OK);
	}
	
	//case 1:
	
	//http://localhost:8080/api/leads/2
	//path parameter
	
	/*@DeleteMapping("/{id}")
	public void deleteLead(@PathVariable("id")long id) {
		leadRepo.deleteById(id);
	}*/
	//case 2:
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteLead(@PathVariable("id")long id){
		leadRepo.deleteById(id);		
		return new ResponseEntity<String>("record is saved", HttpStatus.OK);
	}
	
}
