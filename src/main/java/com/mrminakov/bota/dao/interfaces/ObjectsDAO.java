package com.mrminakov.bota.dao.interfaces;

import com.mrminakov.bota.domain.Objects;
import java.util.List;

/**
 *
 * @author Mr.Minakov
 */
public interface ObjectsDAO {

    public void createObject(Objects object);

    public void updateObject(Objects object);

    public void deleteObject(Integer recordId);

    public Objects getByObject(Integer recordId);

    public List<Objects> getByCompany(Integer recordIdCompany);
    
    public List<Objects> getObjects();

    public List<Objects> getByCompanyAndStatus(Integer recordIdCompany, Boolean status);

    public List<Objects> getByUser(Integer recordIdUser);

    public List<Objects> getByUserAndStatus(Integer recordIdUser, Boolean status);

}