package com.github.jhonatafelipe76.andantecomfe.model;


import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name= "Musico")
public class Musico {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name="nome", nullable = false, length = 60)
    private String nome;

    @Column (name="email", nullable = false, unique = true, length = 60)
    private String email;

    @Column (name="telefone", unique = true, length = 60)
    private String telefone;

    @Column (name="instrumento", nullable = false, length = 60)
    private String instrumento;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private NivelMusical nivel;

    @Column(nullable = false)
    private Boolean disponivel;

    @Column (name="data_cadastro", nullable = false, updatable = false)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDateTime dataCadastro;

    // Contrutores

    public Musico() {
    }

    @PrePersist
    public void definirDataCadastro(){
        this.dataCadastro = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public NivelMusical getNivel() {
        return nivel;
    }

    public void setNivel(NivelMusical nivel) {
        this.nivel = nivel;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public void setInstrumento(String instrumento) {
        this.instrumento = instrumento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


