package com.crednovo.app.rest.Controller;

import com.crednovo.app.rest.Repo.UserRepo;
import com.crednovo.app.rest.Models.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class ApiControllers {
	@Autowired
	private UserRepo userRepo;
	
	@GetMapping(value="/")
	public String getPage() {
		 return "Welcome";
	}
	
	@GetMapping(value="/users")
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	
	@PostMapping(value="/save")
	public User saveUser(@RequestBody User user) {
		userRepo.save(user);
		return user;
	}
	
	@PutMapping(value="update/{id}")
	public User updateUser(@PathVariable long id, @RequestBody User user) {
		User updateUser = userRepo.findById(id).get();
		updateUser.setFirstName(user.getFirstName());
		updateUser.setLastName(user.getLastName());
		updateUser.setAge(user.getAge());
		updateUser.setOcupation(user.getOcupation());
		userRepo.save(updateUser);
		return updateUser;
		
	}
	
	@DeleteMapping(value="delete/{id}")
	public void deleteUser(@PathVariable long id) {
		userRepo.deleteById(id);
	}
}
