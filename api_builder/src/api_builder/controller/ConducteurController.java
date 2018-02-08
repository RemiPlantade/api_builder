package api_builder.controller;
import api_builder.bean.Conducteur;
import api_builder.service.ConducteurService;


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
 * Home object for domain model class Conducteur.
 * @see api_builder.bean.Conducteur
 * @author Hibernate Tools
 */
@RestController
@RequestMapping("api_builder")
public class ConducteurController {

	@Autowired
	private ConducteurService conducteurServ;


	@JsonView(Views.ConducteurView.class)
	@GetMapping("conducteur/{id}")
    public ResponseEntity<Conducteur> getArticleById(@PathVariable("id") Integer id) {
		Conducteur instance = conducteurServ.getConducteurById(id);
		return new ResponseEntity<Conducteur>(instance, HttpStatus.OK);
	}
	@JsonView(Views.ConducteurView.class)
	@GetMapping("conducteur/all")
	public ResponseEntity<List<Conducteur>> getAllArticles() {
		List<Conducteur> list = conducteurServ.getAll();
		return new ResponseEntity<List<Conducteur>>(list, HttpStatus.OK);
	}
	
	
	@JsonView(Views.ConducteurView.class)
	@PostMapping("conducteur/post")
	public ResponseEntity<Void> addConducteur(@RequestBody Conducteur instance, UriComponentsBuilder builder) {
                boolean flag = conducteurServ.addConducteur(instance);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                
               	
               		headers.setLocation(builder.path("/Conducteur/{id}").buildAndExpand(instance.getIdconducteur()).toUri());
               	
             
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@JsonView(Views.ConducteurView.class)
	@PutMapping("conducteur/put")
	public ResponseEntity<Conducteur> updateConducteur(@RequestBody Conducteur instance) {
		conducteurServ.updateConducteur(instance);
		return new ResponseEntity<Conducteur>(instance, HttpStatus.OK);
	}
	
	@JsonView(Views.ConducteurView.class)
	@DeleteMapping("conducteur/delete/{id}")
	public ResponseEntity<Void> deleteArticle(@RequestBody Conducteur instance) {
		conducteurServ.deleteConducteur(instance);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

