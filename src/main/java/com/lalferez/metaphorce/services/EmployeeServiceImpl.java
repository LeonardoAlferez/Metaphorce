package com.lalferez.metaphorce.services;

import com.lalferez.metaphorce.modelo.entidades.Employees;
import com.lalferez.metaphorce.services.dao.EmployeeDAO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImpl (EmployeeDAO employeeDAOConst){
        employeeDAO = employeeDAOConst;
    }
    @Override
    @Transactional
    public List<Employees> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employees findById(int id) {
        return employeeDAO.getById(id);
    }

    @Override
    @Transactional
    public void save(Employees employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deletedById(int id) {
        employeeDAO.deleteById(id);
    }

    /*@Override
    public Employees findByTAX(String tax) {
        return employeeDAO.findByTAX(tax);
    }*/
}
