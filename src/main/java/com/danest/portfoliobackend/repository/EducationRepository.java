package com.danest.portfoliobackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.danest.portfoliobackend.domain.Education;

public interface EducationRepository extends CrudRepository<Education, Long> {
}
