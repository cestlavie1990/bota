package com.mrminakov.bota.service.interfaces;

import com.mrminakov.bota.domain.Companies;

/**
 *
 * @author Mr.Minakov
 */
public interface CompaniesService {

    public void createCompany(Companies company);

    public void updateCompany(Companies company);

    public void deleteCompany(Integer recordId);

}