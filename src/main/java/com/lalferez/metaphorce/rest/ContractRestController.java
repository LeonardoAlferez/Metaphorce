package com.lalferez.metaphorce.rest;

import com.lalferez.metaphorce.modelo.entidades.Contract;
import com.lalferez.metaphorce.services.ContractService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
@RestController
@RequestMapping("/api1")
public class ContractRestController {

    private ContractService contractService;

    //2
    @PostMapping("/Contract")
    public Contract addContract(@RequestBody Contract contract){
        contract.setContractId(BigInteger.valueOf(7));
        contractService.save(contract);
        return contract;
    }
}
