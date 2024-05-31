package com.ekan.service;

import com.ekan.model.Documento;
import com.ekan.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public List<Documento> listBeneficiarioId(Long beneficiarioId){
        return documentoRepository.findByBeneficiarioId(beneficiarioId);
    }
}
