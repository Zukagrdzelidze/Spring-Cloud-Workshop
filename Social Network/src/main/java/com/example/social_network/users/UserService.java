package com.example.social_network.users;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private static List<User> users = new ArrayList<>();
  private static int userCount = 0;

  static {
    users.add(new User(++userCount, "Adam", LocalDate.now().minusYears(30)));
    users.add(new User(++userCount, "Eve", LocalDate.now().minusYears(25)));
    users.add(new User(++userCount, "Jim", LocalDate.now().minusYears(20)));
  }

  public List<User> findAll() {
    return users;
  }

  public User findOne(int id) {
    return users.stream().filter(u -> u.getId().equals(id)).findFirst().get();
  }

  public User save(User user) {
    user.setId(++userCount);
    users.add(user);
    return user;
  }
}
