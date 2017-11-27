package com.mrminakov.bota.dao.implementations;

import com.mrminakov.bota.dao.interfaces.ObjectsDAO;
import com.mrminakov.bota.domain.Companies;
import com.mrminakov.bota.domain.Objects;
import java.util.Date;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mr.Minakov
 */
@Repository
public class ObjectsDAOImpl implements ObjectsDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createObject(Companies company, String name, String address, String customer, String generalBuilder, String uqKey) {
        Objects object = new Objects();
        object.setRecordIdCompany(company);
        object.setName(name);
        object.setAddress(address);
        object.setCustomer(customer);
        object.setGeneralBuilder(generalBuilder);
        object.setUqKey(uqKey);
        object.setDateCreated(new Date());
        object.setIsActive(true);
        
        sessionFactory.getCurrentSession().save(object);
    }

    @Override
    public void updateObject(Objects object) {
        sessionFactory.getCurrentSession().update(object);
    }

    @Override
    public void deleteObject(Integer recordId) {
        Objects object = (Objects) sessionFactory.getCurrentSession().load(Objects.class, recordId);
        if (object != null) {
            sessionFactory.getCurrentSession().delete(object);
        }
    }

    @Override
    public Objects getByObject(Integer recordId) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Objects> getByCompany(Integer recordIdCompany) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Objects> getByCompanyAndStatus(Integer recordIdCompany, Boolean status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Objects> getByUser(Integer recordIdUser) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Objects> getByUserAndStatus(Integer recordIdUser, Boolean status) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
