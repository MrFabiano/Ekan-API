package com.ekan.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Beneficiario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private LocalDate dataInclusao;
    private LocalDate dataAtualizacao;
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true, mappedBy = "beneficiario")
    @JsonManagedReference
    private List<Documento> documentos = new ArrayList<>();

}
