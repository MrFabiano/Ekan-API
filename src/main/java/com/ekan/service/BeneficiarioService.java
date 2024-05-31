package com.ekan.service;

import com.ekan.model.Benificiario;
import com.ekan.model.Documento;
import com.ekan.model.dto.BeneficiarioDTO;
import com.ekan.model.dto.DocumentoDTO;
import com.ekan.model.mapper.BeneficiarioMapper;
import com.ekan.repository.BenificiarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeneficiarioService {

    @Autowired
    private BenificiarioRepository benificiarioRepository;
    @Autowired
    private BeneficiarioMapper beneficiarioMapper;

    public BeneficiarioDTO save(BeneficiarioDTO beneficiarioDTO) {
        Benificiario beneficiario = beneficiarioMapper.convertToEntity(beneficiarioDTO);
        Benificiario savedBeneficiario = benificiarioRepository.save(beneficiario);
        return beneficiarioMapper.convertToDto(savedBeneficiario);
    }

    public Benificiario criarBeneficiario(Benificiario beneficiario) {
        if (beneficiario.getDocumentos() != null) {
            for (Documento documento : beneficiario.getDocumentos()) {
                documento.setBeneficiario(beneficiario);
            }
        }
        return benificiarioRepository.save(beneficiario);
    }

    @Transactional
    public Benificiario salvar(Benificiario beneficiario) {
        for (Documento documento : beneficiario.getDocumentos()) {
            documento.setBeneficiario(beneficiario);
        }
        return benificiarioRepository.save(beneficiario);
    }
    public List<BeneficiarioDTO> listarTodos() {
    List<Benificiario> beneficiarios = benificiarioRepository.findAll();
    return beneficiarios.stream()
            .map(beneficiarioMapper::convertToDto)
            .collect(Collectors.toList());
    }

    public BeneficiarioDTO atualizar(Long id, BeneficiarioDTO beneficiarioDTO) {
        Optional<Benificiario> beneficiarioOptional = benificiarioRepository.findById(id);

        if (beneficiarioOptional.isEmpty()) {
            return null;
        }

        Benificiario beneficiarioExistente = beneficiarioOptional.get();
        beneficiarioExistente.setNome(beneficiarioDTO.getNome());
        beneficiarioExistente.setTelefone(beneficiarioDTO.getTelefone());
        beneficiarioExistente.setDataNascimento(beneficiarioDTO.getDataNascimento());
        beneficiarioExistente.setDataInclusao(beneficiarioDTO.getDataInclusao());
        beneficiarioExistente.setDataAtualizacao(beneficiarioDTO.getDataAtualizacao());

        beneficiarioExistente.getDocumentos().clear();
        List<Documento> documentos = beneficiarioDTO.getDocumentos().stream()
                .map(docDto -> beneficiarioMapper.convertToDocumentoEntity(docDto, beneficiarioExistente))
                .toList();
        beneficiarioExistente.getDocumentos().addAll(documentos);

        Benificiario updatedBeneficiario = benificiarioRepository.save(beneficiarioExistente);
        return beneficiarioMapper.convertToDto(updatedBeneficiario);
    }
    public BeneficiarioDTO benificiarioId(Long id) {
        Benificiario beneficiario = benificiarioRepository.findById(id).orElse(null);
        return beneficiario != null ? beneficiarioMapper.convertToDto(beneficiario) : null;
    }

    public boolean deleteById(Long id) {
        if (benificiarioRepository.existsById(id)) {
            benificiarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
