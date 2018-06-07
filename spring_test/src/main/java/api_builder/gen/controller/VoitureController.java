package api_builder.gen.controller;
import api_builder.gen.bean.Voiture;
import api_builder.gen.service.VoitureService;


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
 * Home object for domain model class Voiture.
 * @see api_builder.gen.bean.Voiture
 * @author Hibernate Tools
 */
@RestController
@RequestMapping("api_builder")
public class VoitureController {

	@Autowired
	private VoitureService voitureService;

	@GetMapping("voiture/{id}")
    public ResponseEntity<Voiture> getArticleById(@PathVariable("id") Integer id) {
		Voiture instance = voitureService.findVoitureById(id);
		return new ResponseEntity<Voiture>(instance, HttpStatus.OK);
	}

	@GetMapping("voiture/all")
	public ResponseEntity<List<Voiture>> getAllArticles() {
		List<Voiture> list = voitureService.findAll();
		return new ResponseEntity<List<Voiture>>(list, HttpStatus.OK);
	}
	
	@PostMapping("voiture/post")
	public ResponseEntity<Void> addVoiture(@RequestBody Voiture instance, UriComponentsBuilder builder) {
        voitureService.save(instance);
        // return new ResponseEntity<Void>(HttpStatus.CONFLICT); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/Voiture/{id}").buildAndExpand(instance.getId()).toUri());
             
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("voiture/put")
	public ResponseEntity<Voiture> updateVoiture(@RequestBody Voiture instance) {
		voitureService.save(instance);
		return new ResponseEntity<Voiture>(instance, HttpStatus.OK);
	}
	
	@DeleteMapping("voiture/delete/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		voitureService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

