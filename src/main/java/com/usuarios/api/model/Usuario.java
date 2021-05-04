/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.api.model;


import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Fergunson
 */

@Entity //Informa ao JPA e Hibernate que a classe será uma tabela do BD
public class Usuario {     
    @Id //chave da tabela do BD
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Modo de incremento do ID
    @Column(nullable=false,unique=true) ////Garante que a variável e-mail será única no 
    private Long id;
 
    @Email //Valida que a variável email será no formato de um e-mail
    @Column(nullable=false,unique=true)
    @NotBlank//Valida que a variável não está em branco
    private String email;
    
    @Column(nullable=false)
    @NotBlank
    private String nome;

    @Column(nullable=false,unique=true)
    @Digits(integer = 11, fraction = 0)//verifica se a string CPF contem 11 números 
    @Size(min=11, max=11) //verifica se o cpf informado contem 11 dígitos
    @NotBlank
    private String cpf;
    
    @Column(nullable=false)
    @DateTimeFormat //valida se o dado recebido é uma data
    @NotNull
    private Date nascimento;
    //Construtor e demais métodos
    public Usuario() {
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.email);
        hash = 53 * hash + Objects.hashCode(this.nome);
        hash = 53 * hash + Objects.hashCode(this.cpf);
        hash = 53 * hash + Objects.hashCode(this.nascimento);
        return hash;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.nascimento, other.nascimento)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public Date getNascimento() {
        return nascimento;
    }
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }
    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", email=" + email + ", nome=" + nome + ", cpf=" + cpf + ", nascimento=" + nascimento + '}';
    }
    
}
