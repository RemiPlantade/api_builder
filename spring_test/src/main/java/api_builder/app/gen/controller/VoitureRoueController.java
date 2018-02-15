package api_builder.app.gen.controller;

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

import api_builder.app.gen.jackson.Views;
import api_builder.app.gen.model.Voiture;
import api_builder.app.gen.model.VoitureRoue;
import api_builder.app.gen.model.VoitureRoueId;
import api_builder.app.gen.service.iface.VoitureRoueService;
import api_builder.app.gen.service.iface.VoitureService;

@Controller
@RequestMapping("test")
public class VoitureRoueController {
	@Autowired
	private VoitureRoueService voitureRoueService;
//	@JsonView(Views.VoitureRoueView.class)
	@GetMapping("voitureroue/{id}")
	public ResponseEntity<VoitureRoue> getArticleById(@PathVariable("id") VoitureRoueId id) {
		VoitureRoue voitureroue = voitureRoueService.getVoitureRoueById(id);
		return new ResponseEntity<VoitureRoue>(voitureroue, HttpStatus.OK);
	}
//	@JsonView(Views.VoitureRoueView.class)
	@GetMapping("voitureroue/all")
	public ResponseEntity<List<VoitureRoue>> getAllArticles() {
		List<VoitureRoue> list = voitureRoueService.getAll();
		return new ResponseEntity<List<VoitureRoue>>(list, HttpStatus.OK);
	}
//	@JsonView(Views.VoitureRoueView.class)
	@PostMapping("voitureroue")
	public ResponseEntity<Void> addArticle(@RequestBody VoitureRoue voitureroue, UriComponentsBuilder builder) {
                boolean flag = voitureRoueService.addVoitureRoue(voitureroue);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/voitureroue/{id}").buildAndExpand(voitureroue.getId()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
//	@JsonView(Views.VoitureRoueView.class)
	@PutMapping("voitureroue")
	public ResponseEntity<VoitureRoue> updateArticle(@RequestBody VoitureRoue voitureroue) {
		voitureRoueService.updateVoitureRoue(voitureroue);
		return new ResponseEntity<VoitureRoue>(voitureroue, HttpStatus.OK);
	}
//	@JsonView(Views.VoitureRoueView.class)
	@DeleteMapping("voitureroue/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") VoitureRoueId id) {
		voitureRoueService.deleteVoitureRoue(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
