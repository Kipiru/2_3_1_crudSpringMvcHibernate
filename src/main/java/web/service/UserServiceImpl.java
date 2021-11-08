package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userDao.findAll();
    }

    @Override
    public void create(User user) {
        userDao.save(user);
    }

    @Override
    public Optional<User> read(int id) {
        return userDao.findById(id);
    }


    @Override
    public void delete(int id) {
        userDao.deleteById(id);
    }

    public void updateUser(User user) {
        Optional<User> userFromDb = userDao.findById(user.getId());

       userFromDb.get().setName(user.getName());
       userFromDb.get().setLastName(user.getLastName());
       userFromDb.get().setAge(user.getAge());
       userDao.save(userFromDb.get());
    }
}
