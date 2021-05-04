/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.api.repository;

import com.usuarios.api.model.Usuario;
import com.usuarios.api.model.Vacina;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Fergunson
 */
@Repository
public interface VacinaRepository extends JpaRepository <Vacina,Long>{
    Optional<Vacina> findByEmail(String email);
    boolean existsByEmail(String email);
}
