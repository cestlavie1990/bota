package com.mrminakov.bota.dao;

/**
 *
 * @author Mr.Minakov
 */
public interface CompaniesDAO {

    public void createCompany(
            final String email,
            final String companyName,
            final String password,
            final String passwordConfirm,
            final String login,
            final String username,
            final String position);

    public void createCompany(
            final String email,
            final String companyName,
            final String password,
            final String passwordConfirm,
            final String login,
            final String username);

}
