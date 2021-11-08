package web.service;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAll();

    void create(User user);

    Optional<User> read(int id);

    void delete(int id);

    void updateUser(User user);

}
