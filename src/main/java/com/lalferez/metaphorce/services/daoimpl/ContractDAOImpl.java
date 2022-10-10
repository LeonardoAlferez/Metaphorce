package com.lalferez.metaphorce.services.daoimpl;

import com.lalferez.metaphorce.modelo.entidades.Contract;
import com.lalferez.metaphorce.services.dao.ContractDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

public class ContractDAOImpl implements ContractDAO {

    private EntityManager entityManager;

    @Autowired
    public ContractDAOImpl(EntityManager entityManagerConst){
        entityManager = entityManagerConst;
    }

    @Override
    @Transactional
    public List<Contract> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Contract> query = currentSession.createQuery("from Contract", Contract.class);
        List<Contract> contractList = query.getResultList();
        return contractList;
    }

    @Override
    public void save(Contract contract) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(contract);
    }

    @Override
    public Contract getById(int id) {
        return null;
    }


}
