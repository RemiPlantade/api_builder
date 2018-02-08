package api_builder.controller;
import api_builder.bean.Voiture;
import api_builder.service.VoitureService;


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
import api_builder.jackson.Views;

// Generated 8 févr. 2018 16:16:11 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class Voiture.
 * @see api_builder.bean.Voiture
 * @author Hibernate Tools
 */
@RestController
@RequestMapping("api_builder")
public class VoitureController {

	@Autowired
	private VoitureService voitureServ;


	@JsonView(Views.VoitureView.class)
	@GetMapping("voiture/{id}")
    public ResponseEntity<Voiture> getArticleById(@PathVariable("id") Integer id) {
		Voiture instance = voitureServ.getVoitureById(id);
		return new ResponseEntity<Voiture>(instance, HttpStatus.OK);
	}
	@JsonView(Views.VoitureView.class)
	@GetMapping("voiture/all")
	public ResponseEntity<List<Voiture>> getAllArticles() {
		List<Voiture> list = voitureServ.getAll();
		return new ResponseEntity<List<Voiture>>(list, HttpStatus.OK);
	}
	
	
	@JsonView(Views.VoitureView.class)
	@PostMapping("voiture/post")
	public ResponseEntity<Void> addVoiture(@RequestBody Voiture instance, UriComponentsBuilder builder) {
                boolean flag = voitureServ.addVoiture(instance);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                
               	
               		headers.setLocation(builder.path("/Voiture/{id}").buildAndExpand(instance.getIdvoiture()).toUri());
               	
             
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@JsonView(Views.VoitureView.class)
	@PutMapping("voiture/put")
	public ResponseEntity<Voiture> updateVoiture(@RequestBody Voiture instance) {
		voitureServ.updateVoiture(instance);
		return new ResponseEntity<Voiture>(instance, HttpStatus.OK);
	}
	
	@JsonView(Views.VoitureView.class)
	@DeleteMapping("voiture/delete/{id}")
	public ResponseEntity<Void> deleteArticle(@RequestBody Voiture instance) {
		voitureServ.deleteVoiture(instance);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

