package api_builder.gen.api.controller;
import api_builder.gen.api.bean.Roue;
import api_builder.gen.api.service.impl.RoueServiceImpl;


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
 * Home object for domain model class Roue.
 * @see api_builder.gen.api.bean.Roue
 * @author Hibernate Tools
 */
@Controller
@RequestMapping("api_builder")
public class RoueController {

	@Autowired
	private RoueServiceImpl RoueServ;


	@JsonView(Views.RoueView.class)
	@GetMapping("Roue/{id}")
    public ResponseEntity<Roue> getArticleById(@PathVariable("id") Integer id) {
		Roue instance = RoueServ.getRoueById(id);
		return new ResponseEntity<Roue>(instance, HttpStatus.OK);
	}
	@JsonView(Views.RoueView.class)
	@GetMapping("Roue/all")
	public ResponseEntity<List<Roue>> getAllArticles() {
		List<Roue> list = RoueServ.getAll();
		return new ResponseEntity<List<Roue>>(list, HttpStatus.OK);
	}
	
	
	@JsonView(Views.RoueView.class)
	@PostMapping("Roue")
	public ResponseEntity<Void> addRoue(@RequestBody Roue instance, UriComponentsBuilder builder) {
                boolean flag = RoueServ.addRoue(instance);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                
               	
               		headers.setLocation(builder.path("/Roue/{id}").buildAndExpand(instance.getIdroue()).toUri());
               	
             
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@JsonView(Views.RoueView.class)
	@PutMapping("Roue")
	public ResponseEntity<Roue> updateRoue(@RequestBody Roue instance) {
		RoueServ.updateRoue(instance);
		return new ResponseEntity<Roue>(instance, HttpStatus.OK);
	}
	
	@JsonView(Views.RoueView.class)
	@DeleteMapping("Roue/{id}")
	public ResponseEntity<Void> deleteArticle(@RequestBody Roue instance) {
		RoueServ.deleteRoue(instance);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

