package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.dao.UserDao;
import web.model.User;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.getAll();

    }

    @Override
    @Transactional
    public void create(User user) {
        userDao.create(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User readById(int id) {
        return userDao.readById(id);
    }


    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        User userFromDb = userDao.readById(user.getId());
        userFromDb.setName(user.getName());
        userFromDb.setLastName(user.getLastName());
        userFromDb.setAge(user.getAge());
        userDao.updateUser(userFromDb);
    }
}
