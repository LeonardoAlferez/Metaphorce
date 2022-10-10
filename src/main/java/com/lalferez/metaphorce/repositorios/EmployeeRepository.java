package com.lalferez.metaphorce.repositorios;

import com.lalferez.metaphorce.modelo.entidades.Employees;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EmployeeRepository extends CrudRepository<Employees, Integer> {

}
