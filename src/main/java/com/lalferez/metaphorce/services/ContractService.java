package com.lalferez.metaphorce.services;

import com.lalferez.metaphorce.modelo.entidades.Contract;

import java.util.List;

public interface ContractService {
    public List<Contract> findAll();

    public Contract findById(int id);

    public void save(Contract contract);
}
