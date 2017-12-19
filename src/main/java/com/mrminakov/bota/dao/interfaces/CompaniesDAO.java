package com.mrminakov.bota.dao.interfaces;

import com.mrminakov.bota.domain.Companies;

/**
 *
 * @author Mr.Minakov
 */
public interface CompaniesDAO {

    public void createCompany(Companies company);

    public void updateCompany(Companies company);

    public void deleteCompany(Integer recordId);

}