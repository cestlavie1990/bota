package com.mrminakov.bota.managers;

import com.mrminakov.bota.domain.Companies;
import com.mrminakov.bota.exceptions.CompanyLoginAlreadyUsedException;
import com.mrminakov.bota.exceptions.EmailAlreadyUsedException;
import com.mrminakov.bota.exceptions.EmptyParameterException;
import com.mrminakov.bota.service.interfaces.CompaniesService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Mr.Minakov
 */
public class CompanyManager {

    @Autowired
    private CompaniesService companiesService;

    public Companies create(
            final String name,
            final String email,
            final String companyLogin) throws EmptyParameterException, EmailAlreadyUsedException, CompanyLoginAlreadyUsedException {
        if (hasEmptyParameter(name, email, companyLogin)) {
            throw new EmptyParameterException();
        } else if (isEmailUsed(email)) {
            throw new EmailAlreadyUsedException();
        } else if (isCompanyLoginUsed(companyLogin)) {
            throw new CompanyLoginAlreadyUsedException();
        }

        Companies company = new Companies();
        company.setCompanyLogin(companyLogin);
        company.setEmail(email);
        company.setName(name);
        company.setDateRegistration(new Date());

        return company;
    }

    private boolean isEmailUsed(final String email) {
        return companiesService.getByEmail(email) == null;
    }

    private boolean isCompanyLoginUsed(final String companyLogin) {
        return companiesService.getByCompanyLogin(companyLogin) == null;
    }

    private boolean hasEmptyParameter(
            final String name,
            final String email,
            final String companyLogin) {
        return name.equals("") || email.equals("") || companyLogin.equals("");
    }

}
