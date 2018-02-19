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

import api_builder.app.conf.model.User;
import api_builder.app.conf.service.UserService;

@Controller
@RequestMapping("test")
public class UserController {

	@Autowired
	private UserService userService;

//	@JsonView(Views.UserView.class)
	@GetMapping("user/{id}")
	public ResponseEntity<User> getArticleById(@PathVariable("id") Integer id) {
		User user = userService.getUserById(id);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
//	@JsonView(Views.UserView.class)
	@GetMapping("user/all")
	public ResponseEntity<List<User>> getAllArticles() {
		List<User> list = userService.getAll();
		return new ResponseEntity<List<User>>(list, HttpStatus.OK);
	}
//	@JsonView(Views.UserView.class)
	@PostMapping("user")
	public ResponseEntity<Void> addArticle(@RequestBody User user, UriComponentsBuilder builder) {
		boolean flag = userService.addUser(user);
		if (flag == false) {
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(builder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
//	@JsonView(Views.UserView.class)
	@PutMapping("user")
	public ResponseEntity<User> updateArticle(@RequestBody User user) {
		userService.updateUser(user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
//	@JsonView(Views.UserView.class)
	@DeleteMapping("user/{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		userService.deleteUser(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
}
