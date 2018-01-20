package com.mrminakov.bota.service.implementations;

import com.mrminakov.bota.dao.interfaces.GroupUsersDAO;
import com.mrminakov.bota.domain.GroupUsers;
import com.mrminakov.bota.domain.Users;
import com.mrminakov.bota.service.interfaces.GroupUsersService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mr.Minakov
 */
@Service
public class GroupUsersServiceImpl implements GroupUsersService{
    
    @Autowired
    private GroupUsersDAO groupUsersDAO;

    @Transactional
    public void create(GroupUsers groupUser) {
        groupUsersDAO.create(groupUser);
    }

    @Transactional
    public void update(GroupUsers groupUser) {
        groupUsersDAO.update(groupUser);
    }

    @Transactional
    public void delete(Integer recordId) {
        groupUsersDAO.delete(recordId);
    }
    
}
