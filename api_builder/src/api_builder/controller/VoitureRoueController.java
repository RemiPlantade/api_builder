package api_builder.controller;
import api_builder.bean.VoitureRoueId;
import api_builder.bean.VoitureRoue;
import api_builder.service.VoitureRoueService;


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
 * Home object for domain model class VoitureRoue.
 * @see api_builder.bean.VoitureRoue
 * @author Hibernate Tools
 */
@RestController
@RequestMapping("api_builder")
public class VoitureRoueController {

	@Autowired
	private VoitureRoueService voitureroueServ;


	@JsonView(Views.VoitureRoueView.class)
	@GetMapping("voitureroue/{id}")
    public ResponseEntity<VoitureRoue> getArticleById(@PathVariable("id") VoitureRoueId id) {
		VoitureRoue instance = voitureroueServ.getVoitureRoueById(id);
		return new ResponseEntity<VoitureRoue>(instance, HttpStatus.OK);
	}
	@JsonView(Views.VoitureRoueView.class)
	@GetMapping("voitureroue/all")
	public ResponseEntity<List<VoitureRoue>> getAllArticles() {
		List<VoitureRoue> list = voitureroueServ.getAll();
		return new ResponseEntity<List<VoitureRoue>>(list, HttpStatus.OK);
	}
	
	
	@JsonView(Views.VoitureRoueView.class)
	@PostMapping("voitureroue/post")
	public ResponseEntity<Void> addVoitureRoue(@RequestBody VoitureRoue instance, UriComponentsBuilder builder) {
                boolean flag = voitureroueServ.addVoitureRoue(instance);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                
               	
               		headers.setLocation(builder.path("/VoitureRoue/{id}").buildAndExpand(instance.getId()).toUri());
               	
             
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@JsonView(Views.VoitureRoueView.class)
	@PutMapping("voitureroue/put")
	public ResponseEntity<VoitureRoue> updateVoitureRoue(@RequestBody VoitureRoue instance) {
		voitureroueServ.updateVoitureRoue(instance);
		return new ResponseEntity<VoitureRoue>(instance, HttpStatus.OK);
	}
	
	@JsonView(Views.VoitureRoueView.class)
	@DeleteMapping("voitureroue/delete/{id}")
	public ResponseEntity<Void> deleteArticle(@RequestBody VoitureRoue instance) {
		voitureroueServ.deleteVoitureRoue(instance);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

