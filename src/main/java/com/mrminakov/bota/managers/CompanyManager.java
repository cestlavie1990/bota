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
            final String companyLogin) {
        Companies company = new Companies();

        return company;
    }

}
