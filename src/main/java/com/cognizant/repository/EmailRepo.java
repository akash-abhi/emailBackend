package com.cognizant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.entity.Email;

@Repository
public interface EmailRepo extends JpaRepository<Email, Integer> {

}
