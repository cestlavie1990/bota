package com.mrminakov.bota.dao.interfaces;

import com.mrminakov.bota.domain.Companies;
import com.mrminakov.bota.domain.Objects;
import com.mrminakov.bota.domain.Users;
import java.util.List;

/**
 *
 * @author Mr.Minakov
 */
public interface UsersDAO {

    public void createUser(
            Companies company,
            String login,
            String password,
            String role,
            String name,
            String position);

    public void createUser(
            Companies company,
            String login,
            String password,
            String role,
            String name);

    public void updateUser(Users user);

    public void deleteUser(Integer recordId);

    public Users getByUser(Integer recordId);

    public List<Users> getByCompany(Integer recordIdCompany);

    public List<Users> getByObject(Integer recordIdObject);

    public List<Users> getNameAndLoginByCompany(Integer recordIdCompany);
}
