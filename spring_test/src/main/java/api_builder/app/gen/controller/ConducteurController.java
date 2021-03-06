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
import api_builder.app.gen.model.Conducteur;
import api_builder.app.gen.service.iface.ConducteurService;

@Controller
@RequestMapping("test")
public class ConducteurController {

	@Autowired
	private ConducteurService conducteurService;

	@JsonView(Views.ConducteurView.class)
	@GetMapping("conducteur/{id}")
	public ResponseEntity<Conducteur> getArticleById(@PathVariable("id") Integer id) {
		Conducteur conducteur = conducteurService.getConducteurById(id);
		return new ResponseEntity<Conducteur>(conducteur, HttpStatus.OK);
	}
	@JsonView(Views.ConducteurView.class)
	@GetMapping("conducteur/all")
	public ResponseEntity<List<Conducteur>> getAllArticles() {
		List<Conducteur> list = conducteurService.getAll();
		return new ResponseEntity<List<Conducteur>>(list, HttpStatus.OK);
	}
	@JsonView(Views.ConducteurView.class)
	@PostMapping("conducteur")
	public ResponseEntity<Void> addArticle(@RequestBody Conducteur conducteur, UriComponentsBuilder builder) {
		boolean flag = conducteurService.addConducteur(conducteur);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/conducteur/{id}").buildAndExpand(conducteur.getIdconducteur()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@JsonView(Views.ConducteurView.class)
	@PutMapping("conducteur")
	public ResponseEntity<Conducteur> updateArticle(@RequestBody Conducteur conducteur) {
		conducteurService.updateConducteur(conducteur);
		return new ResponseEntity<Conducteur>(conducteur, HttpStatus.OK);
	}
	@JsonView(Views.ConducteurView.class)
	@DeleteMapping("conducteur/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		conducteurService.deleteConducteur(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
