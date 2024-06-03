package com.ekan.service;

import com.ekan.model.Beneficiario;
import com.ekan.model.Documento;
import com.ekan.model.dto.BeneficiarioDTO;
import com.ekan.model.mapper.BeneficiarioMapper;
import com.ekan.repository.BeneficiarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;
    @Autowired
    private BeneficiarioMapper beneficiarioMapper;

    public BeneficiarioDTO save(BeneficiarioDTO beneficiarioDTO) {
        Beneficiario beneficiario = beneficiarioMapper.convertToEntity(beneficiarioDTO);
        Beneficiario beneficiarioSave = beneficiarioRepository.save(beneficiario);
        return  beneficiarioMapper.convertToDto(beneficiarioSave);
    }

    public Beneficiario criarBeneficiario(Beneficiario beneficiario) {
        if (beneficiario.getDocumentos() != null) {
            for (Documento documento : beneficiario.getDocumentos()) {
                documento.setBeneficiario(beneficiario);
            }
        }
        return beneficiarioRepository.save(beneficiario);
    }

    @Transactional
    public Beneficiario salvar(Beneficiario beneficiario) {
        for (Documento documento : beneficiario.getDocumentos()) {
            documento.setBeneficiario(beneficiario);
        }
        return beneficiarioRepository.save(beneficiario);
    }
    public List<BeneficiarioDTO> listarTodos() {
    List<Beneficiario> beneficiarios = beneficiarioRepository.findAll();
    return beneficiarios.stream()
            .map(beneficiarioMapper::convertToDto)
            .collect(Collectors.toList());
    }

    public BeneficiarioDTO atualizar(Long id, BeneficiarioDTO beneficiarioDTO) {
        Optional<Beneficiario> beneficiarioOptional = beneficiarioRepository.findById(id);

        if (beneficiarioOptional.isEmpty()) {
            return null;
        }

        Beneficiario beneficiarioExistente = beneficiarioOptional.get();
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

        Beneficiario updatedBeneficiario = beneficiarioRepository.save(beneficiarioExistente);
        return beneficiarioMapper.convertToDto(updatedBeneficiario);
    }
    public BeneficiarioDTO benificiarioId(Long id) {
        Beneficiario beneficiario = beneficiarioRepository.findById(id).orElse(null);
        return beneficiario != null ? beneficiarioMapper.convertToDto(beneficiario) : null;
    }

    public boolean deleteById(Long id) {
        if (beneficiarioRepository.existsById(id)) {
            beneficiarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
