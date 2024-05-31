package com.example.demo.Company;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

	private CompanyService service;

	public CompanyController(CompanyService service) {
		this.service = service;
	}
	
	@GetMapping
	public ResponseEntity<List<Company>> getALl(){
		return new ResponseEntity<>(service.getAllCompanies(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Company> getById(@PathVariable Long id){
		Company company = service.getCompanyById(id);
		if(company != null) {
			return new ResponseEntity<>(company,HttpStatus.OK);
		}
		return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<String> createCompany(@RequestBody Company company) {
		service.createCompany(company);
		return new ResponseEntity<>("Created succesfully", HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company updateCopany){
		if(service.updateCompany(updateCopany, id)) {
			return new ResponseEntity<>("Update Succesfull",HttpStatus.OK);
		}
		return new ResponseEntity<>("Update Failed",HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable Long id){
			if(service.deleteCompany(id)) {
			return new ResponseEntity<>("Delete Succesfull",HttpStatus.OK);
			}
			return new ResponseEntity<>("Delete Failed",HttpStatus.NOT_FOUND);
	}
	
//	@PutMapping("/{id}")
//	public ResponseEntity<String> modifyCompany(@PathVariable Long id, @RequestBody Company company){
//		if(service.updateCompany(company, id)) {
//			return new ResponseEntity<>("Company updated successfully", HttpStatus.OK);
//		}
//		return new ResponseEntity<>("Company updation failed", HttpStatus.NOT_FOUND);
//	}
}
