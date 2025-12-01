package com.example.social_network.users;

import com.example.social_network.exception.UserNotFoundException;
import java.net.URI;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  public List<User> getUsers() {
    return userService.findAll();
  }

  @GetMapping("{id}")
  public User retrieveUser(@PathVariable int id) {
    User user = userService.findOne(id);
    if (user == null) {
      throw new UserNotFoundException(String.format("User with id %s not found", id));
    }

    return user;
  }

  @PostMapping
  public ResponseEntity<Object> createUser(@RequestBody User user) {
    User createdUser = userService.save(user);
    URI location =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(createdUser.getId())
            .toUri();
    return ResponseEntity.created(location).build();
  }

  @DeleteMapping("{id}")
  public void deleteUser(@PathVariable int id) {
    userService.deleteById(id);
  }
}
