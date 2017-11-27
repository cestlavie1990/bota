package com.mrminakov.bota.service.implementations;

import com.mrminakov.bota.dao.interfaces.ObjectsDAO;
import com.mrminakov.bota.domain.Companies;
import com.mrminakov.bota.domain.Objects;
import com.mrminakov.bota.service.interfaces.ObjectsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mr.Minakov
 */
@Service
public class ObjectsServiceImpl implements ObjectsService {

    @Autowired
    private ObjectsDAO objectsDAO;

    @Override
    public void createObject(Companies company, String name, String address, String customer, String generalBuilder, String uqKey) {
        objectsDAO.createObject(company, name, address, customer, generalBuilder, uqKey);
    }

    @Override
    public void updateObject(Objects object) {
        objectsDAO.updateObject(object);
    }

    @Override
    public void deleteObject(Integer recordId) {
        objectsDAO.deleteObject(recordId);
    }

    @Override
    public Objects getByObject(Integer recordId) {
        return objectsDAO.getByObject(recordId);
    }

    @Override
    public List<Objects> getByCompany(Integer recordIdCompany) {
        return objectsDAO.getByCompany(recordIdCompany);
    }

    @Override
    public List<Objects> getByCompanyAndStatus(Integer recordIdCompany, Boolean status) {
        return objectsDAO.getByCompanyAndStatus(recordIdCompany, status);
    }

    @Override
    public List<Objects> getByUser(Integer recordIdUser) {
        return objectsDAO.getByUser(recordIdUser);
    }

    @Override
    public List<Objects> getByUserAndStatus(Integer recordIdUser, Boolean status) {
        return objectsDAO.getByUserAndStatus(recordIdUser, status);
    }

}
