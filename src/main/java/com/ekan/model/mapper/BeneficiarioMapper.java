package com.ekan.model.mapper;

import com.ekan.model.Beneficiario;

import com.ekan.model.Documento;
import com.ekan.model.dto.BeneficiarioDTO;
import com.ekan.model.dto.DocumentoDTO;
import com.ekan.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BeneficiarioMapper {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public Beneficiario convertToEntity(BeneficiarioDTO beneficiarioDTO) {
        Beneficiario beneficiario = new Beneficiario();
        beneficiario.setId(beneficiarioDTO.getId());
        beneficiario.setNome(beneficiarioDTO.getNome());
        beneficiario.setTelefone(beneficiarioDTO.getTelefone());
        beneficiario.setDataNascimento(beneficiarioDTO.getDataNascimento());
        beneficiario.setDataInclusao(beneficiarioDTO.getDataInclusao());
        beneficiario.setDataAtualizacao(beneficiarioDTO.getDataAtualizacao());

        List<DocumentoDTO> documentosDTO = beneficiarioDTO.getDocumentos();
        if (documentosDTO != null) {
            List<Documento> documentos = documentosDTO.stream()
                    .map(docDto -> convertToDocumentoEntity(docDto, beneficiario))
                    .collect(Collectors.toList());
            beneficiario.setDocumentos(documentos);
        }

        return beneficiario;
    }

    public Documento convertToDocumentoEntity(DocumentoDTO documentoDTO, Beneficiario beneficiario) {
        Documento documento = new Documento();
        documento.setId(documentoDTO.getId());
        documento.setTipoDocumento(documentoDTO.getTipoDocumento());
        documento.setDescricao(documentoDTO.getDescricao());
        documento.setDataInclusao(documentoDTO.getDataInclusao());
        documento.setDataAtualizacao(documentoDTO.getDataAtualizacao());
        documento.setBeneficiario(beneficiario);
        return documento;
    }


    public BeneficiarioDTO convertToDto(Beneficiario beneficiario) {
        BeneficiarioDTO beneficiarioDTO = new BeneficiarioDTO();
        beneficiarioDTO.setId(beneficiario.getId());
        beneficiarioDTO.setNome(beneficiario.getNome());
        beneficiarioDTO.setTelefone(beneficiario.getTelefone());
        beneficiarioDTO.setDataNascimento(beneficiario.getDataNascimento());
        beneficiarioDTO.setDataInclusao(beneficiario.getDataInclusao());
        beneficiarioDTO.setDataAtualizacao(beneficiario.getDataAtualizacao());

        List<DocumentoDTO> documentos = beneficiario.getDocumentos().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        beneficiarioDTO.setDocumentos(documentos);

        return beneficiarioDTO;
    }

    public DocumentoDTO convertToDto(Documento documento) {
        DocumentoDTO documentoDTO = new DocumentoDTO();
        documentoDTO.setId(documento.getId());
        documentoDTO.setTipoDocumento(documento.getTipoDocumento());
        documentoDTO.setDescricao(documento.getDescricao());
        documentoDTO.setDataInclusao(documento.getDataInclusao());
        documentoDTO.setDataAtualizacao(documento.getDataAtualizacao());

        BeneficiarioDTO beneficiarioDTO = new BeneficiarioDTO();
        Beneficiario benificiario = documento.getBeneficiario();
        beneficiarioDTO.setId(benificiario.getId());
        beneficiarioDTO.setNome(benificiario.getNome());
        beneficiarioDTO.setTelefone(benificiario.getTelefone());
        beneficiarioDTO.setDataNascimento(benificiario.getDataNascimento());
        beneficiarioDTO.setDataInclusao(benificiario.getDataInclusao());
        beneficiarioDTO.setDataAtualizacao(benificiario.getDataAtualizacao());

        documentoDTO.setBeneficiario(beneficiarioDTO);

        return documentoDTO;
    }
}
