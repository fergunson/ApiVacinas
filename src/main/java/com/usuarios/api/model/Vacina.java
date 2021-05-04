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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

/*
 *
 * @author Fergunson
 */
@Entity
public class Vacina {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable=false,unique=true)
    private Long id;
    
    @Email
    @Column(nullable=false,unique=true)
    @NotBlank
    private String email;
    
    @Column(nullable=false)
    @DateTimeFormat
    @NotNull
    private Date data;
    
    @Column(nullable=false, name = "manufacturer")
    @NotBlank
    private String nomeVacina;
    //Construtor e demais métodos
    public Vacina() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.email);
        hash = 17 * hash + Objects.hashCode(this.data);
        hash = 17 * hash + Objects.hashCode(this.nomeVacina);
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
        final Vacina other = (Vacina) obj;
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.nomeVacina, other.nomeVacina)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.data, other.data)) {
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
    public String getNomeVacina() {
        return nomeVacina;
    }
    public void setNomeVacina(String nomeVacina) {
        this.nomeVacina = nomeVacina;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }  

    @Override
    public String toString() {
        return "Vacina{" + "id=" + id + ", email=" + email + ", data=" + data + ", nomeVacina=" + nomeVacina + '}';
    }
}
