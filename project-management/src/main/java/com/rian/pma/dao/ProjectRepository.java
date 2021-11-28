package com.rian.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.rian.pma.entities.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
