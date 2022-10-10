package com.lalferez.metaphorce.rest;

import com.lalferez.metaphorce.modelo.entidades.Contract;
import com.lalferez.metaphorce.modelo.entidades.Employees;
import com.lalferez.metaphorce.services.EmployeeService;
import com.lalferez.metaphorce.services.dao.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeServiceConst){
        employeeService = employeeServiceConst;
    }
    //query implemented into EmployeeDaoImpl with just active employees
    @GetMapping("/employees")
    public List<Employees> findAll(){
        if (employeeService.findAll().isEmpty())
            throw new RuntimeException("Empty List - Null");
        return employeeService.findAll();
    }
    //1
    @GetMapping("/employees/{employeId}")
    public Employees getEmployee(@PathVariable int employeId){
        Employees employee = employeeService.findById(employeId);
        if (employee == null){
            throw new RuntimeException("null - " + employeId);
        }else return employee;
    }



    //3)
    @PostMapping("/employees")
    public Employees addEmployee(@RequestBody Employees employee){
        //if is it correct RFC then save it
        //String regex = "^[A-Z]{4}[0-9]{6}[A-Z]{3}";
        //Pattern p = Pattern.compile(regex);
        //Matcher matcher = p.matcher(employee.getTaxIdNumber());
        //If not exist in DB then save it
        /*Employees employeet = employeeService.findByTAX(employee.getTaxIdNumber());
        if (employeet.getTaxIdNumber()== null){
            throw new RuntimeException("Not valid");
        } /*else if (!(matcher.matches())) {
            throw new RuntimeException("Not valid");
        }else*/
        employee.setEmployeeId(0);
        employeeService.save(employee);
        return employee;
    }

    //4
    @PutMapping("/employee")
    public Employees updateEmployee(@RequestBody Employees employee)
    {
        employeeService.save(employee);
        return employee;
    }

    //5
    @DeleteMapping("/employee/{employeId}")
    public String deleteEmployee(@PathVariable int employeId){
        Employees temp = employeeService.findById(employeId);
        if(temp == null){
            throw new RuntimeException("Employee not found");
        }employeeService.deletedById(employeId);
        return "Employee deleted";
    }
}
