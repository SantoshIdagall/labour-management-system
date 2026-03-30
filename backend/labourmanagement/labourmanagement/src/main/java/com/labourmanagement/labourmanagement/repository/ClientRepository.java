package com.labourmanagement.labourmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labourmanagement.labourmanagement.entity.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
	
}