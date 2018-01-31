package com.mrminakov.bota.service.interfaces;

import com.mrminakov.bota.domain.Users;
import java.util.List;

/**
 *
 * @author Mr.Minakov
 */
public interface UsersService {

    public void createUser(Users user);

    public void updateUser(Users user);

    public void deleteUser(Integer recordId);

    public Users getByUser(Integer recordId);
    
    public Users getByUsername(String username);

    public List<Users> getByCompany(Integer recordIdCompany);

    public List<Users> getByObject(Integer recordIdObject);

    public List<Users> getNameAndLoginByCompany(Integer recordIdCompany);

}