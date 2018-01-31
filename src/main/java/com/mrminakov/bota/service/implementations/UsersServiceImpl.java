package com.mrminakov.bota.service.implementations;

import com.mrminakov.bota.dao.interfaces.UsersDAO;
import com.mrminakov.bota.domain.Users;
import com.mrminakov.bota.service.interfaces.UsersService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mr.Minakov
 */
@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersDAO usersDAO;

    @Transactional
    public void createUser(Users user) {
        usersDAO.createUser(user);
    }

    @Transactional
    public void updateUser(Users user) {
        usersDAO.updateUser(user);
    }

    @Transactional
    public void deleteUser(Integer recordId) {
        usersDAO.deleteUser(recordId);
    }

    @Transactional
    public Users getByUser(Integer recordId) {
        return usersDAO.getByUser(recordId);
    }

    @Transactional
    public List<Users> getByCompany(Integer recordIdCompany) {
        return usersDAO.getByCompany(recordIdCompany);
    }

    @Transactional
    public List<Users> getByObject(Integer recordIdObject) {
        return usersDAO.getByObject(recordIdObject);
    }

    @Transactional
    public List<Users> getNameAndLoginByCompany(Integer recordIdCompany) {
        return usersDAO.getNameAndLoginByCompany(recordIdCompany);
    }

    @Transactional
    public Users getByUsername(String username) {
        return usersDAO.getByUsername(username);
    }

}