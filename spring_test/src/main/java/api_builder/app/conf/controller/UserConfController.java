package api_builder.app.conf.controller;

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

import api_builder.app.conf.model.UserConf;
import api_builder.app.conf.service.UserConfService;

@Controller
@RequestMapping("test")
public class UserConfController {

	@Autowired
	private UserConfService userconfService;

//	@JsonView(Views.UserView.class)
	@GetMapping("userconf/{id}")
	public ResponseEntity<UserConf> getArticleById(@PathVariable("id") Integer id) {
		UserConf userconf = userconfService.getUserById(id);
		return new ResponseEntity<UserConf>(userconf, HttpStatus.OK);
	}
//	@JsonView(Views.UserView.class)
	@GetMapping("userconf/all")
	public ResponseEntity<List<UserConf>> getAllArticles() {
		List<UserConf> list = userconfService.getAll();
		return new ResponseEntity<List<UserConf>>(list, HttpStatus.OK);
	}
//	@JsonView(Views.UserView.class)
	@PostMapping("userconf")
	public ResponseEntity<Void> addArticle(@RequestBody UserConf userconf, UriComponentsBuilder builder) {
		boolean flag = userconfService.addUser(userconf);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/userconf/{id}").buildAndExpand(userconf.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
//	@JsonView(Views.UserView.class)
	@PutMapping("userconf")
	public ResponseEntity<UserConf> updateArticle(@RequestBody UserConf userconf) {
		userconfService.updateUser(userconf);
		return new ResponseEntity<UserConf>(userconf, HttpStatus.OK);
	}
//	@JsonView(Views.UserView.class)
	@DeleteMapping("userconf/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		userconfService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
