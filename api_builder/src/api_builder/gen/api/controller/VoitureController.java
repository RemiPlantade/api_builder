package api_builder.gen.api.controller;
import api_builder.gen.api.bean.Voiture;
import api_builder.gen.api.service.impl.VoitureServiceImpl;


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
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import api_builder.gen.jackson.Views;

// Generated 7 févr. 2018 16:17:48 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class Voiture.
 * @see api_builder.gen.api.bean.Voiture
 * @author Hibernate Tools
 */
@Controller
@RequestMapping("api_builder")
public class VoitureController {

	@Autowired
	private VoitureServiceImpl VoitureServ;


	@JsonView(Views.VoitureView.class)
	@GetMapping("Voiture/{id}")
    public ResponseEntity<Voiture> getArticleById(@PathVariable("id") Integer id) {
		Voiture instance = VoitureServ.getVoitureById(id);
		return new ResponseEntity<Voiture>(instance, HttpStatus.OK);
	}
	@JsonView(Views.VoitureView.class)
	@GetMapping("Voiture/all")
	public ResponseEntity<List<Voiture>> getAllArticles() {
		List<Voiture> list = VoitureServ.getAll();
		return new ResponseEntity<List<Voiture>>(list, HttpStatus.OK);
	}
	
	
	@JsonView(Views.VoitureView.class)
	@PostMapping("Voiture")
	public ResponseEntity<Void> addVoiture(@RequestBody Voiture instance, UriComponentsBuilder builder) {
                boolean flag = VoitureServ.addVoiture(instance);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                
               	
               		headers.setLocation(builder.path("/Voiture/{id}").buildAndExpand(instance.getIdvoiture()).toUri());
               	
             
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@JsonView(Views.VoitureView.class)
	@PutMapping("Voiture")
	public ResponseEntity<Voiture> updateVoiture(@RequestBody Voiture instance) {
		VoitureServ.updateVoiture(instance);
		return new ResponseEntity<Voiture>(instance, HttpStatus.OK);
	}
	
	@JsonView(Views.VoitureView.class)
	@DeleteMapping("Voiture/{id}")
	public ResponseEntity<Void> deleteArticle(@RequestBody Voiture instance) {
		VoitureServ.deleteVoiture(instance);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

