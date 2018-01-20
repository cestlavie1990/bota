package com.mrminakov.bota.dao.interfaces;

import com.mrminakov.bota.domain.GroupUsers;

/**
 *
 * @author Mr.Minakov
 */
public interface GroupUsersDAO {

    public void create(GroupUsers groupUser);

    public void update(GroupUsers groupUser);

    public void delete(Integer recordId);
}
