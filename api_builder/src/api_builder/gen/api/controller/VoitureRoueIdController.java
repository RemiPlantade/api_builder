package api_builder.gen.api.controller;
import api_builder.gen.api.bean.VoitureRoueId;
import api_builder.gen.api.service.impl.VoitureRoueIdServiceImpl;


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
 * Home object for domain model class VoitureRoueId.
 * @see api_builder.gen.api.bean.VoitureRoueId
 * @author Hibernate Tools
 */
@Controller
@RequestMapping("api_builder")
public class VoitureRoueIdController {

	@Autowired
	private VoitureRoueIdServiceImpl VoitureRoueIdServ;


	@GetMapping("VoitureRoueId/{id}")
    public ResponseEntity<VoitureRoueId> getArticleById(@PathVariable("id") int id) {
		VoitureRoueId instance = VoitureRoueIdServ.getVoitureRoueIdById(id);
		return new ResponseEntity<VoitureRoueId>(instance, HttpStatus.OK);
	}
	@GetMapping("VoitureRoueId/all")
	public ResponseEntity<List<VoitureRoueId>> getAllArticles() {
		List<VoitureRoueId> list = VoitureRoueIdServ.getAll();
		return new ResponseEntity<List<VoitureRoueId>>(list, HttpStatus.OK);
	}
	
	
	@PostMapping("VoitureRoueId")
	public ResponseEntity<Void> addVoitureRoueId(@RequestBody VoitureRoueId instance, UriComponentsBuilder builder) {
                boolean flag = VoitureRoueIdServ.addVoitureRoueId(instance);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                
             
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@PutMapping("VoitureRoueId")
	public ResponseEntity<VoitureRoueId> updateVoitureRoueId(@RequestBody VoitureRoueId instance) {
		VoitureRoueIdServ.updateVoitureRoueId(instance);
		return new ResponseEntity<VoitureRoueId>(instance, HttpStatus.OK);
	}
	
	@DeleteMapping("VoitureRoueId/{id}")
	public ResponseEntity<Void> deleteArticle(@RequestBody VoitureRoueId instance) {
		VoitureRoueIdServ.deleteVoitureRoueId(instance);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
    
}

