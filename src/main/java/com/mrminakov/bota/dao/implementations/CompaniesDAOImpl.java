package com.mrminakov.bota.dao.implementations;

import com.mrminakov.bota.dao.interfaces.CompaniesDAO;
import com.mrminakov.bota.domain.Companies;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mr.Minakov
 */
@Repository
public class CompaniesDAOImpl implements CompaniesDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createCompany(Companies company) {
        sessionFactory.getCurrentSession().save(company);
    }

    @Override
    public void updateCompany(Companies company) {
        sessionFactory.getCurrentSession().update(company);
    }

    @Override
    public void deleteCompany(Integer recordId) {
        Companies company = (Companies) sessionFactory.getCurrentSession().load(Companies.class, recordId);
        if (company != null) {
            sessionFactory.getCurrentSession().delete(company);
        }
    }

    @Override
    public Companies getByCompany(Integer recordId) {
        return (Companies) sessionFactory.getCurrentSession().createQuery("from Companies where recordId = " + recordId).uniqueResult();
    }

    @Override
    public Companies getByCompanyLogin(String companyLogin) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Companies where companyLogin =:companyLogin");
        query.setParameter("companyLogin", companyLogin);
        return (Companies) query.uniqueResult();
    }

    @Override
    public Companies getByEmail(String email) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Companies where email =:email");
        query.setParameter("email", email);
        return (Companies) query.uniqueResult();
    }

    @Override
    public List<Companies> getCompanies() {
        return sessionFactory.getCurrentSession().createQuery("from Companies").list();
    }

}
