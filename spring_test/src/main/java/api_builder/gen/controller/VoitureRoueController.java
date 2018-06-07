package api_builder.gen.controller;
import api_builder.gen.bean.VoitureRoueId;
import api_builder.gen.bean.VoitureRoue;
import api_builder.gen.service.VoitureRoueService;


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
 * Home object for domain model class VoitureRoue.
 * @see api_builder.gen.bean.VoitureRoue
 * @author Hibernate Tools
 */
@RestController
@RequestMapping("api_builder")
public class VoitureRoueController {

	@Autowired
	private VoitureRoueService voitureroueService;

	@GetMapping("voitureroue/{id}")
    public ResponseEntity<VoitureRoue> getArticleById(@PathVariable("id") VoitureRoueId id) {
		VoitureRoue instance = voitureroueService.findVoitureRoueById(id);
		return new ResponseEntity<VoitureRoue>(instance, HttpStatus.OK);
	}

	@GetMapping("voitureroue/all")
	public ResponseEntity<List<VoitureRoue>> getAllArticles() {
		List<VoitureRoue> list = voitureroueService.findAll();
		return new ResponseEntity<List<VoitureRoue>>(list, HttpStatus.OK);
	}
	
	@PostMapping("voitureroue/post")
	public ResponseEntity<Void> addVoitureRoue(@RequestBody VoitureRoue instance, UriComponentsBuilder builder) {
        voitureroueService.save(instance);
        // return new ResponseEntity<Void>(HttpStatus.CONFLICT); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/VoitureRoue/{id}").buildAndExpand(instance.getId()).toUri());
             
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("voitureroue/put")
	public ResponseEntity<VoitureRoue> updateVoitureRoue(@RequestBody VoitureRoue instance) {
		voitureroueService.save(instance);
		return new ResponseEntity<VoitureRoue>(instance, HttpStatus.OK);
	}
	
	@DeleteMapping("voitureroue/delete/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") VoitureRoueId id) {
		voitureroueService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

