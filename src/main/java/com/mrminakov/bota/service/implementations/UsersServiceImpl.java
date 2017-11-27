package com.mrminakov.bota.service.implementations;

import com.mrminakov.bota.dao.interfaces.UsersDAO;
import com.mrminakov.bota.domain.Companies;
import com.mrminakov.bota.domain.Users;
import com.mrminakov.bota.service.interfaces.UsersService;
import java.util.List;
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

    @Override
    public void createUser(Companies company, String login, String password, String role, String name, String position) {
        usersDAO.createUser(company, login, password, role, name, position);
    }

    @Override
    public void createUser(Companies company, String login, String password, String role, String name) {
        usersDAO.createUser(company, login, password, role, name);
    }

    @Override
    public void updateUser(Users user) {
        usersDAO.updateUser(user);
    }

    @Override
    public void deleteUser(Integer recordId) {
        usersDAO.deleteUser(recordId);
    }

    @Override
    public Users getByUser(Integer recordId) {
        return usersDAO.getByUser(recordId);
    }

    @Override
    public List<Users> getByCompany(Integer recordIdCompany) {
        return usersDAO.getByCompany(recordIdCompany);
    }

    @Override
    public List<Users> getByObject(Integer recordIdObject) {
        return usersDAO.getByObject(recordIdObject);
    }

    @Override
    public List<Users> getNameAndLoginByCompany(Integer recordIdCompany) {
        return usersDAO.getNameAndLoginByCompany(recordIdCompany);
    }

}
