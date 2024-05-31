package com.ekan.repository;

import com.ekan.model.Benificiario;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BenificiarioRepository extends JpaRepository<Benificiario, Long> {

//    @Override
//    @EntityGraph(attributePaths = "documentos")
//    List<Benificiario> findAll();
}
