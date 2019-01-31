package com.nbu.secretsanta.secretsanta.repository;

import com.nbu.secretsanta.secretsanta.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Long>{
    Admin getOne(Long aLong);
}
