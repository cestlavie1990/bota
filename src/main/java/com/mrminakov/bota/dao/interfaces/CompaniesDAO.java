package com.mrminakov.bota.dao.interfaces;

import com.mrminakov.bota.domain.Companies;

/**
 *
 * @author Mr.Minakov
 */
public interface CompaniesDAO {

    public void createCompany(String name, String email);

    public void updateCompany(Companies company);

    public void deleteCompany(Integer recordId);

}
