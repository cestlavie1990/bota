package com.mrminakov.bota.service.interfaces;

import com.mrminakov.bota.domain.Companies;
import java.util.List;

/**
 *
 * @author Mr.Minakov
 */
public interface CompaniesService {

    public void createCompany(Companies company);

    public void updateCompany(Companies company);

    public void deleteCompany(Integer recordId);

    public Companies getByCompany(Integer recordId);

    public Companies getByCompanyLogin(String companyLogin);
    
    public Companies getByEmail(String email);

    public List<Companies> getCompanies();

}
