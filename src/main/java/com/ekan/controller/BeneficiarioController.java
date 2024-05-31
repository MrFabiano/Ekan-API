package com.ekan.controller;

import com.ekan.model.dto.BeneficiarioDTO;
import com.ekan.service.BeneficiarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/beneficiarios")
public class BeneficiarioController {

    private final BeneficiarioService beneficiarioService;


    @Autowired
    public BeneficiarioController(BeneficiarioService beneficiarioService) {
        this.beneficiarioService = beneficiarioService;
    }

    @PostMapping
    public ResponseEntity<BeneficiarioDTO> createBeneficiario(@RequestBody BeneficiarioDTO beneficiarioDTO) {
        BeneficiarioDTO savedBeneficiario = beneficiarioService.save(beneficiarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBeneficiario);
    }

    @GetMapping
    public ResponseEntity<List<BeneficiarioDTO>> getLisAll() {
        List<BeneficiarioDTO> beneficiariosDTO = beneficiarioService.listarTodos();
        return ResponseEntity.ok(beneficiariosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BeneficiarioDTO> getBuscarPorId(@PathVariable Long id) {
        BeneficiarioDTO buscarBeneficiario = beneficiarioService.benificiarioId(id);
        return buscarBeneficiario != null ? ResponseEntity.ok(buscarBeneficiario) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<BeneficiarioDTO> putUpdate(@PathVariable Long id, @RequestBody BeneficiarioDTO beneficiarioDTO) {
        BeneficiarioDTO updatedBeneficiario = beneficiarioService.atualizar(id, beneficiarioDTO);
        return updatedBeneficiario != null ? ResponseEntity.ok(updatedBeneficiario) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        boolean isRemoved = beneficiarioService.deleteById(id);
        if (!isRemoved) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
