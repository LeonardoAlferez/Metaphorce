package com.lalferez.metaphorce.services;

import com.lalferez.metaphorce.modelo.entidades.Contract;
import com.lalferez.metaphorce.services.dao.ContractDAO;

import java.util.List;

public class ContractServiceImpl implements ContractService{

    private ContractDAO contractDAO;
    public ContractServiceImpl (ContractDAO contractDAOConst){
        contractDAO = contractDAOConst;
    }

    @Override
    public List<Contract> findAll() {
        return contractDAO.findAll();
    }

    @Override
    public Contract findById(int id) {
        return contractDAO.getById(id);
    }

    @Override
    public void save(Contract contract) {
        contractDAO.save(contract);
    }
}
