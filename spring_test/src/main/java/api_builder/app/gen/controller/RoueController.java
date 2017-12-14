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
import api_builder.app.gen.model.Roue;
import api_builder.app.gen.service.iface.RoueService;

@Controller
@RequestMapping("test")
public class RoueController {

	@Autowired
	private RoueService roueService;

	@JsonView(Views.RoueView.class)
	@GetMapping("roue/{id}")
	public ResponseEntity<Roue> getArticleById(@PathVariable("id") Integer id) {
		Roue roue = roueService.getRoueById(id);
		return new ResponseEntity<Roue>(roue, HttpStatus.OK);
	}
	@JsonView(Views.RoueView.class)
	@GetMapping("roue/all")
	public ResponseEntity<List<Roue>> getAllArticles() {
		List<Roue> list = roueService.getAll();
		return new ResponseEntity<List<Roue>>(list, HttpStatus.OK);
	}
	@JsonView(Views.RoueView.class)
	@PostMapping("roue")
	public ResponseEntity<Void> addArticle(@RequestBody Roue roue, UriComponentsBuilder builder) {
		boolean flag = roueService.addRoue(roue);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/roue/{id}").buildAndExpand(roue.getIdroue()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@JsonView(Views.RoueView.class)
	@PutMapping("roue")
	public ResponseEntity<Roue> updateArticle(@RequestBody Roue roue) {
		roueService.updateRoue(roue);
		return new ResponseEntity<Roue>(roue, HttpStatus.OK);
	}
	@JsonView(Views.RoueView.class)
	@DeleteMapping("roue/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		roueService.deleteRoue(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
