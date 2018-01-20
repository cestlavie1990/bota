package com.mrminakov.bota.dao.implementations;

import com.mrminakov.bota.dao.interfaces.GroupUsersDAO;
import com.mrminakov.bota.domain.GroupUsers;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mr.Minakov
 */
@Repository
public class GroupUsersDAOImpl implements GroupUsersDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(GroupUsers groupUser) {
        sessionFactory.getCurrentSession().save(groupUser);
    }

    @Override
    public void update(GroupUsers groupUser) {
        sessionFactory.getCurrentSession().update(groupUser);
    }

    @Override
    public void delete(Integer recordId) {
        GroupUsers groupUser = (GroupUsers) sessionFactory.getCurrentSession().load(GroupUsers.class, recordId);
        if (groupUser != null) {
            sessionFactory.getCurrentSession().delete(groupUser);
        }
    }

}
