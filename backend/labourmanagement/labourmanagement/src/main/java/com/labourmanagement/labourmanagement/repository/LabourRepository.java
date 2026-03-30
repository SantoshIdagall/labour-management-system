package com.labourmanagement.labourmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labourmanagement.labourmanagement.entity.Labour;

@Repository
public interface LabourRepository extends JpaRepository<Labour, Long> {

}
