package com.mrminakov.bota.dao.interfaces;

import com.mrminakov.bota.domain.Users;
import java.util.List;

/**
 *
 * @author Mr.Minakov
 */
public interface UsersDAO {

    public void createUser(Users user);

    public void updateUser(Users user);

    public void deleteUser(Integer recordId);

    public Users getByUser(Integer recordId);
    
    public Users getByLogin(String login);

    public List<Users> getByCompany(Integer recordIdCompany);

    public List<Users> getByObject(Integer recordIdObject);

    public List<Users> getNameAndLoginByCompany(Integer recordIdCompany);
}