package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public final class SearchFacade {

    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);

    public List<Company> searchCompanies(String arg) {
        List<Company> searchResult = companyDao.retrieveCompanyByNameContaining(arg);
        LOGGER.info("Searching companies names containing \"" + arg + "\"...");
        if (searchResult.size() == 0) {
            LOGGER.info("No companies found.");
            return searchResult;
        }
        for (Company company : searchResult) {
            LOGGER.info("Found: " + company.getName());
        }
        return searchResult;
    }

    public List<Employee> searchEmployees(String arg) {
        List<Employee> searchResult = employeeDao.retrieveEmployeesWithLastNameContaining(arg);
        LOGGER.info("Searching employees last names containing \"" + arg + "\"...");
        if (searchResult.size() == 0) {
            LOGGER.info("No employees found.");
            return searchResult;
        }
        for (Employee employee : searchResult) {
            LOGGER.info("Found: " + employee.getFirstname() + " " + employee.getLastname());
        }
        return searchResult;
    }

}
