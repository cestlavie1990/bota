package com.mrminakov.bota.service.interfaces;

import com.mrminakov.bota.domain.GroupUsers;

/**
 *
 * @author Mr.Minakov
 */
public interface GroupUsersService {

    public void create(GroupUsers groupUser);

    public void update(GroupUsers groupUser);

    public void delete(Integer recordId);
    
}
