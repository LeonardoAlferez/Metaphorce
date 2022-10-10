package com.lalferez.metaphorce.services.dao;

import com.lalferez.metaphorce.modelo.entidades.Employees;

import java.util.List;

public interface EmployeeDAO {
    List<Employees> findAll();

    public void save(Employees employee);

    public Employees getById(int id);

    public void deleteById(int id);

    //public  Employees findByTAX(String tax);
}
