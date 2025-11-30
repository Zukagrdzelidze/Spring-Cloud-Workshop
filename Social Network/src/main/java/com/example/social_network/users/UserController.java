package com.example.social_network.users;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    return userService.findOne(id);
  }

  @PostMapping
  public User createUser(@RequestBody User user) {
    return userService.save(user);
  }
}
