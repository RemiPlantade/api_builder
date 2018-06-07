package api_builder.gen.controller;
import api_builder.gen.bean.Conducteur;
import api_builder.gen.service.ConducteurService;

import static org.mockito.Matchers.intThat;

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
 * Home object for domain model class Conducteur.
 * @see api_builder.gen.bean.Conducteur
 * @author Hibernate Tools
 */
@RestController
@RequestMapping("api_builder")
public class ConducteurController {

	@Autowired
	private ConducteurService conducteurService;

	@GetMapping("conducteur/{id}")
    public ResponseEntity<Conducteur> getArticleById(@PathVariable("id") Integer id) {
		Conducteur instance = conducteurService.findConducteurById(id);
		return new ResponseEntity<Conducteur>(instance, HttpStatus.OK);
	}

	@GetMapping("conducteur/all")
	public ResponseEntity<List<Conducteur>> getAllArticles() {
		List<Conducteur> list = conducteurService.findAll();
		return new ResponseEntity<List<Conducteur>>(list, HttpStatus.OK);
	}
	
	@PostMapping("conducteur/post")
	public ResponseEntity<Void> addConducteur(@RequestBody Conducteur instance, UriComponentsBuilder builder) {
        conducteurService.save(instance);
        // return new ResponseEntity<Void>(HttpStatus.CONFLICT); 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/Conducteur/{id}").buildAndExpand(instance.getId()).toUri());
             
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("conducteur/put")
	public ResponseEntity<Conducteur> updateConducteur(@RequestBody Conducteur instance) {
		conducteurService.save(instance);
		return new ResponseEntity<Conducteur>(instance, HttpStatus.OK);
	}
	
	@DeleteMapping("conducteur/delete/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		conducteurService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

