/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.api.controller;

import com.usuarios.api.model.Vacina;
import com.usuarios.api.repository.UsuarioRepository;
import com.usuarios.api.repository.VacinaRepository;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vacinas")
public class VacinasController {
    @Autowired            
    private VacinaRepository vacinaRepository;
    @Autowired            
    private UsuarioRepository usuarioRepository; //Repositório de usuarios para verificar quem está sendo vacinado
    @GetMapping
    public List<Vacina> listar(){
        return vacinaRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Object> addVacina(@Valid @RequestBody Vacina vacina, BindingResult results){
        if(results.hasErrors()){
            return new ResponseEntity<>("Dados da solicitação errados",HttpStatus.BAD_REQUEST);  
        }
        if(vacinaRepository.existsByEmail(vacina.getEmail())){ //Verifica se o email está cadastrado na base de usuários
            return new ResponseEntity<>("Vacinação já cadastrada.",HttpStatus.BAD_REQUEST);
        }
        if(!usuarioRepository.existsByEmail(vacina.getEmail())){
            return new ResponseEntity<>("Usuario não encontrado.",HttpStatus.BAD_REQUEST);
        }else{
            try{
                vacinaRepository.save(vacina);
                return new ResponseEntity<>(vacina,HttpStatus.CREATED);
            }catch(Exception e){
                return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
            }
        }
    }
}
