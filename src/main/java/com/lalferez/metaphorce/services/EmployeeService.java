package com.lalferez.metaphorce.services;

import com.lalferez.metaphorce.modelo.entidades.Employees;

import java.util.List;

public interface EmployeeService {

    public List<Employees> findAll();

    public Employees findById(int id);

    public void save(Employees employee);

    public void deletedById(int id);

    //public Employees findByTAX(String tax);
}
