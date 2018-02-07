package api_builder.gen.api.controller;
import api_builder.gen.api.bean.VoitureRoueId;
import api_builder.gen.api.bean.VoitureRoue;
import api_builder.gen.api.service.impl.VoitureRoueServiceImpl;


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

// Generated 8 févr. 2018 00:41:33 by Hibernate Tools 6.0.0-SNAPSHOT
// Improved by AbouCorp



/**
 * Home object for domain model class VoitureRoue.
 * @see api_builder.gen.api.bean.VoitureRoue
 * @author Hibernate Tools
 */
@Controller
@RequestMapping("api_builder")
public class VoitureRoueController {

	@Autowired
	private VoitureRoueServiceImpl VoitureRoueServ;


	@JsonView(Views.VoitureRoueView.class)
	@GetMapping("VoitureRoue/{id}")
    public ResponseEntity<VoitureRoue> getArticleById(@PathVariable("id") VoitureRoueId id) {
		VoitureRoue instance = VoitureRoueServ.getVoitureRoueById(id);
		return new ResponseEntity<VoitureRoue>(instance, HttpStatus.OK);
	}
	@JsonView(Views.VoitureRoueView.class)
	@GetMapping("VoitureRoue/all")
	public ResponseEntity<List<VoitureRoue>> getAllArticles() {
		List<VoitureRoue> list = VoitureRoueServ.getAll();
		return new ResponseEntity<List<VoitureRoue>>(list, HttpStatus.OK);
	}
	
	
	@JsonView(Views.VoitureRoueView.class)
	@PostMapping("VoitureRoue")
	public ResponseEntity<Void> addVoitureRoue(@RequestBody VoitureRoue instance, UriComponentsBuilder builder) {
                boolean flag = VoitureRoueServ.addVoitureRoue(instance);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                
               	
               		headers.setLocation(builder.path("/VoitureRoue/{id}").buildAndExpand(instance.getId()).toUri());
               	
             
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@JsonView(Views.VoitureRoueView.class)
	@PutMapping("VoitureRoue")
	public ResponseEntity<VoitureRoue> updateVoitureRoue(@RequestBody VoitureRoue instance) {
		VoitureRoueServ.updateVoitureRoue(instance);
		return new ResponseEntity<VoitureRoue>(instance, HttpStatus.OK);
	}
	
	@JsonView(Views.VoitureRoueView.class)
	@DeleteMapping("VoitureRoue/{id}")
	public ResponseEntity<Void> deleteArticle(@RequestBody VoitureRoue instance) {
		VoitureRoueServ.deleteVoitureRoue(instance);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

