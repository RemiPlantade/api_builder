package api_builder.gen.controller;
import api_builder.gen.bean.Roue;
import api_builder.gen.service.RoueService;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import api_builder.gen.jackson.Views;

// Generated 16 mars 2018 15:14:24 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class Roue.
 * @see api_builder.gen.bean.Roue
 * @author Hibernate Tools
 */
@RestController
@RequestMapping("api_builder")
public class RoueController {

	@Autowired
	private RoueService roueService;

	@GetMapping("roue/{id}")
    public ResponseEntity<Roue> getArticleById(@PathVariable("id") Integer id) {
		Roue instance = roueService.findRoueById(id);
		return new ResponseEntity<Roue>(instance, HttpStatus.OK);
	}

	@GetMapping("roue/all")
	public ResponseEntity<List<Roue>> getAllArticles() {
		List<Roue> list = roueService.findAll();
		return new ResponseEntity<List<Roue>>(list, HttpStatus.OK);
	}
	
	@PostMapping("roue/post")
	public ResponseEntity<Void> addRoue(@RequestBody Roue instance, UriComponentsBuilder builder) {
        roueService.save(instance);
        // return new ResponseEntity<Void>(HttpStatus.CONFLICT); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/Roue/{id}").buildAndExpand(instance.getId()).toUri());
             
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("roue/put")
	public ResponseEntity<Roue> updateRoue(@RequestBody Roue instance) {
		roueService.save(instance);
		return new ResponseEntity<Roue>(instance, HttpStatus.OK);
	}
	
	@DeleteMapping("roue/delete/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		roueService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

