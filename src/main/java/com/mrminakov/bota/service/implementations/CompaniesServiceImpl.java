package com.mrminakov.bota.service.implementations;

import com.mrminakov.bota.dao.interfaces.CompaniesDAO;
import com.mrminakov.bota.domain.Companies;
import com.mrminakov.bota.service.interfaces.CompaniesService;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mr.Minakov
 */
@Service
public class CompaniesServiceImpl implements CompaniesService {

    @Autowired
    private CompaniesDAO companiesDAO;

    @Transactional
    public void createCompany(Companies company) {
        companiesDAO.createCompany(company);
    }

    @Transactional
    public void updateCompany(Companies company) {
        companiesDAO.updateCompany(company);
    }

    @Transactional
    public void deleteCompany(Integer recordId) {
        companiesDAO.deleteCompany(recordId);
    }

    @Transactional
    public Companies getByCompany(Integer recordId) {
        return companiesDAO.getByCompany(recordId);
    }

    @Transactional
    public Companies getByCompanyLogin(String companyLogin) {
        return companiesDAO.getByCompanyLogin(companyLogin);
    }

    @Transactional
    public Companies getByEmail(String email) {
        return companiesDAO.getByEmail(email);
    }

    @Transactional
    public List<Companies> getCompanies() {
        return companiesDAO.getCompanies();
    }

}
