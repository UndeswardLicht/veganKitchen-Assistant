package project.service.impl;

import project.dao.UserDao;
import project.dao.impl.UserDaoImpl;
import project.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public boolean authenticate(String login, String password) {
        //todo password encoding
        String passEncoded = password;
        UserDao userDao = new UserDaoImpl();
        String passResult = userDao.authenticate(login, passEncoded);
        return passEncoded.equals(passResult);
    }
}
