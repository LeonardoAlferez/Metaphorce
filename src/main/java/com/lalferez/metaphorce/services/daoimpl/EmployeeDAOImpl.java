package com.lalferez.metaphorce.services.daoimpl;

import com.lalferez.metaphorce.modelo.entidades.Employees;
import com.lalferez.metaphorce.services.dao.EmployeeDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
    //Lets define entityManager
    private EntityManager entityManager;

    //Set up constructor inj
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManagerConst){
        entityManager = entityManagerConst;
    }

    @Override
    @Transactional
    public List<Employees> findAll() {
        //Current session
        Session currentSession = entityManager.unwrap(Session.class);
        //Create query
        Query<Employees> query= currentSession.createQuery("select  Concat(employees.name,concat(' ',employees.last_name)), employees,tax_id_number, employees.email, contract_type.name, employees.date_created, contract.salary_per_day from employees, contrac_type, contract where contract_type.is_active = true;", Employees.class);
        //Execute query
        List<Employees> employeesList = query.getResultList();
        //return
        return employeesList;
    }

    @Override
    @Transactional
    public void save(Employees employee) {
//Current session
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public Employees getById(int id) {
        //Current session
        Session currentSession = entityManager.unwrap(Session.class);
        Employees employee = currentSession.get(Employees.class, id);
        return employee;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
//Current session
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Employees where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

    /*@Override
    public Employees findByTAX(String tax) {
        Session currentSession = entityManager.unwrap(Session.class);
        Employees employee = currentSession.get(Employees.class,tax);
        return employee;
    }*/
}
