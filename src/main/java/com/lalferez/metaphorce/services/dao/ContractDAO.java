package com.lalferez.metaphorce.services.dao;

import com.lalferez.metaphorce.modelo.entidades.Contract;

import java.util.List;

public interface ContractDAO {
    List<Contract> findAll();

    public void save(Contract contract);

    public Contract getById(int id);

}
