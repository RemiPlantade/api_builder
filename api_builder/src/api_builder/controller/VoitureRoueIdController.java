package api_builder.controller;
import api_builder.bean.VoitureRoueId;
import api_builder.service.VoitureRoueIdService;


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
 * Home object for domain model class VoitureRoueId.
 * @see api_builder.bean.VoitureRoueId
 * @author Hibernate Tools
 */
@RestController
@RequestMapping("api_builder")
public class VoitureRoueIdController {

	@Autowired
	private VoitureRoueIdService voitureroueidServ;


	@GetMapping("voitureroueid/{id}")
    public ResponseEntity<VoitureRoueId> getArticleById(@PathVariable("id") int id) {
		VoitureRoueId instance = voitureroueidServ.getVoitureRoueIdById(id);
		return new ResponseEntity<VoitureRoueId>(instance, HttpStatus.OK);
	}
	@GetMapping("voitureroueid/all")
	public ResponseEntity<List<VoitureRoueId>> getAllArticles() {
		List<VoitureRoueId> list = voitureroueidServ.getAll();
		return new ResponseEntity<List<VoitureRoueId>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("voitureroueid/post")
	public ResponseEntity<Void> addVoitureRoueId(@RequestBody VoitureRoueId instance, UriComponentsBuilder builder) {
                boolean flag = voitureroueidServ.addVoitureRoueId(instance);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                
             
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("voitureroueid/put")
	public ResponseEntity<VoitureRoueId> updateVoitureRoueId(@RequestBody VoitureRoueId instance) {
		voitureroueidServ.updateVoitureRoueId(instance);
		return new ResponseEntity<VoitureRoueId>(instance, HttpStatus.OK);
	}
	
	@DeleteMapping("voitureroueid/delete/{id}")
	public ResponseEntity<Void> deleteArticle(@RequestBody VoitureRoueId instance) {
		voitureroueidServ.deleteVoitureRoueId(instance);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

