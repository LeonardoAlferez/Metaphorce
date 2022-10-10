package com.lalferez.metaphorce.modelo.entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Contract")
public class Contract implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger contractId;

    @Column(nullable = false, name = "DateFrom")
    private LocalDateTime dateFrom;
    @Column(nullable = false, name = "DateTo")
    private LocalDateTime dateTo;
    @Column(nullable = false, name = "SalaryPerDay")
    private float salaryPerDay;
    @Column(nullable = false, name = "IsActive")
    private boolean isActive;
    @Column(nullable = false, name = "DateCreated")
    private LocalDateTime dateCreated;

    @ManyToOne
    @JoinColumn(name = "EmployeeId", referencedColumnName = "EmployeeId")
    private Employees employeeId;

    @ManyToOne
    @JoinColumn(name = "ContractTypeId", referencedColumnName = "ContractTypeId")
    private ContractType contractTypeId;
}
