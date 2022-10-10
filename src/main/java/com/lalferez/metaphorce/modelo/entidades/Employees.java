package com.lalferez.metaphorce.modelo.entidades;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "employees")
public class Employees implements Serializable {
    /*Datos de tabla empleados
    * ID (integer, AutoInt)
    * taxidnumber (string 13, not null) //unique***
    * name (String 60, not null)
    * lastName(string 120, not null)
    * birthdate( Date, not null)
    * email(string 60, not null)
    * cellphone(string 20, not null)
    * isActive(boolean not null)
    * date created(Datetime, not null)
    **/
    //attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmployeeId")
    private Integer employeeId;
    @Column(nullable = false, length = 13, name = "TaxIdNumber")
    private String taxIdNumber;
    @Column(nullable = false, length = 60, name = "Name")
    private String name;
    @Column(nullable = false, length = 120, name = "LastName")
    private String lastName;
    @Column(nullable = false, name = "BirthDate")
    private Date birthDay;
    @Column(nullable = false, length = 60, name = "Email")
    private String email;
    @Column(nullable = false, length = 20, name = "CellPhone")
    private String cellPhone;
    @Column(nullable = false, name = "IsActive")
    private Boolean isActive;
    @Column(nullable = false, name = "DateCreated")
    private LocalDateTime dateCreated;

    //Constructors, Getters, and setters
    //Defned with Lombok

}
