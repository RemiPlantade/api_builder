package fr.api_builder.gen.controller;

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

import fr.api_builder.gen.model.Voiture;
import fr.api_builder.gen.service.iface.VoitureService;

@Controller
@RequestMapping("voiture")
public class VoitureController {
	@Autowired
	private VoitureService voitureService;

	@GetMapping("voiture/{id}")
	public ResponseEntity<Voiture> getArticleById(@PathVariable("id") Integer id) {
		Voiture voiture = voitureService.getVoitureById(id);
		return new ResponseEntity<Voiture>(voiture, HttpStatus.OK);
	}
	@GetMapping("voiture/all")
	public ResponseEntity<List<Voiture>> getAllArticles() {
		List<Voiture> list = voitureService.getAll();
		return new ResponseEntity<List<Voiture>>(list, HttpStatus.OK);
	}
	@PostMapping("voiture")
	public ResponseEntity<Void> addArticle(@RequestBody Voiture voiture, UriComponentsBuilder builder) {
                boolean flag = voitureService.addVoiture(voiture);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/voiture/{id}").buildAndExpand(voiture.getIdvoiture()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("voiture")
	public ResponseEntity<Voiture> updateArticle(@RequestBody Voiture voiture) {
		voitureService.updateVoiture(voiture);
		return new ResponseEntity<Voiture>(voiture, HttpStatus.OK);
	}
	@DeleteMapping("voiture/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		voitureService.deleteVoiture(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
