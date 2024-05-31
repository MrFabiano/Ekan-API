package com.ekan.repository;

import com.ekan.model.Benificiario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenificiarioRepository extends JpaRepository<Benificiario, Long> {

}
