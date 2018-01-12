package com.mrminakov.bota.dao.implementations;

import com.mrminakov.bota.dao.interfaces.UsersDAO;
import com.mrminakov.bota.domain.Users;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mr.Minakov
 */
@Repository
public class UsersDAOImpl implements UsersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createUser(Users user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public void updateUser(Users user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public void deleteUser(Integer recordId) {
        Users user = (Users) sessionFactory.getCurrentSession().load(Users.class, recordId);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }

    @Override
    public Users getByUser(Integer recordId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Users> getByCompany(Integer recordIdCompany) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Users> getByObject(Integer recordIdObject) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Users> getNameAndLoginByCompany(Integer recordIdCompany) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Users getByLogin(String login) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Users where login =:login");
        query.setParameter("login", login);
        return (Users) query.uniqueResult();
    }

}
