package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SearchFacadeTestSuite {
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private SearchFacade searchFacade;

    @Test
    public void testSearchCompanies() {
        // Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Smith");

        Company softwareMachine = new Company("Software Machine");
        Company softFinance = new Company("Soft Finance");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        softFinance.getEmployees().add(stephanieClarckson);
        softFinance.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(softFinance);
        lindaKovalsky.getCompanies().add(softFinance);
        lindaKovalsky.getCompanies().add(greyMatter);

        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(softFinance);
        int softFinanceId = softFinance.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //When
        List<Company> maCompanyName = searchFacade.searchCompanies("Ma");
        List<Company> xxCompanyName = searchFacade.searchCompanies("xx");
        List<Employee> miEmployeeName = searchFacade.searchEmployees("mi");
        List<Employee> xxEmployeeName = searchFacade.searchEmployees("xx");

        //Then
        Assert.assertEquals(2, maCompanyName.size());
        Assert.assertEquals(0, xxCompanyName.size());
        Assert.assertEquals(2, miEmployeeName.size());
        Assert.assertEquals(0, xxEmployeeName.size());

        //Cleanup
        try {
            companyDao.delete(softwareMachineId);
            companyDao.delete(softFinanceId);
            companyDao.delete(greyMatterId);
        } catch (Exception e) {
            // do nothing
        }
    }

}
