package com.rian.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.rian.pma.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

}
