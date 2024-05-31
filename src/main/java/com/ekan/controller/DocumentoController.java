package com.ekan.controller;

import com.ekan.model.Documento;
import com.ekan.repository.DocumentoRepository;
import com.ekan.service.DocumentoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/documento")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @GetMapping("/beneficiario/{beneficiarioId}")
    public ResponseEntity<List<Documento>> listDocument(@PathVariable Long beneficiarioId){
        List<Documento> documentos = documentoService.listBeneficiarioId(beneficiarioId);
        return ResponseEntity.ok(documentos);
    }
}
