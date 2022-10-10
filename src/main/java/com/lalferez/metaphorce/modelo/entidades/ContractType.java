package com.lalferez.metaphorce.modelo.entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "contractType")
public class ContractType implements Serializable {
    /*
    * ContractTypeId (short, AutoInt)
    * Name (String 80, not null)
    * Description (string default, nullable
    * isActive (boolean, not null)
    * DateCreated (Datetime, not null)*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short contractTypeId;
    @Column(nullable = false, length = 80, name = "Name")
    private String name;
    @Column (name = "Description")//nullable, 255
    private String description;
    @Column(nullable = false, name = "IsActive")
    private boolean isActive;
    @Column(nullable = false, name = "DateCreated")
    private LocalDateTime dateCreated;
}
