package com.mrminakov.bota.service.implementations;

import com.mrminakov.bota.dao.interfaces.ObjectsDAO;
import com.mrminakov.bota.domain.Objects;
import com.mrminakov.bota.service.interfaces.ObjectsService;
import java.util.List;
import javax.transaction.Transactional;
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

    @Transactional
    public void createObject(Objects object) {
        objectsDAO.createObject(object);
    }

    @Transactional
    public void updateObject(Objects object) {
        objectsDAO.updateObject(object);
    }

    @Transactional
    public void deleteObject(Integer recordId) {
        objectsDAO.deleteObject(recordId);
    }

    @Transactional
    public Objects getByObject(Integer recordId) {
        return objectsDAO.getByObject(recordId);
    }

    @Transactional
    public List<Objects> getByCompany(Integer recordIdCompany) {
        return objectsDAO.getByCompany(recordIdCompany);
    }

    @Transactional
    public List<Objects> getByCompanyAndStatus(Integer recordIdCompany, Boolean status) {
        return objectsDAO.getByCompanyAndStatus(recordIdCompany, status);
    }

    @Transactional
    public List<Objects> getByUser(Integer recordIdUser) {
        return objectsDAO.getByUser(recordIdUser);
    }

    @Transactional
    public List<Objects> getByUserAndStatus(Integer recordIdUser, Boolean status) {
        return objectsDAO.getByUserAndStatus(recordIdUser, status);
    }

    @Transactional
    public List<Objects> getObjects() {
        return objectsDAO.getObjects();
    }

}