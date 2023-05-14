package com.danest.portfoliobackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.danest.portfoliobackend.domain.Project;

public interface ProjectRepository extends CrudRepository<Project, Long> {

}
