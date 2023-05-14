package com.danest.portfoliobackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.danest.portfoliobackend.domain.Profile;
import com.danest.portfoliobackend.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

    @Query("SELECT u.profile FROM User u WHERE u.id=1")
    Profile findOnlyUserProfile();

    @Query("SELECT u FROM User u WHERE u.id=1")
    User findOnlyUser();

    Optional<User> findByUsername(String username);
}
