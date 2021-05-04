/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usuarios.api.controller;

import com.usuarios.api.model.Usuario;
import com.usuarios.api.repository.UsuarioRepository;
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

@RestController //define que esta Classe é do tipo controlador REST
@RequestMapping("/usuarios") //define o endpoint da nossa API REST
public class UsuariosController {
    @Autowired //Faz a injeção do repositório de Usuários automaticamente       
    private UsuarioRepository usuarioRepository;
    @GetMapping //Define a função que irá escutar as solicitaçõe HHTP GET 
    public List<Usuario> listar() { //retorna uma lista de usuários
        return usuarioRepository.findAll(); //acessa o repositório e retorna todos usuarios encontrados
    }
    @PostMapping //Define a função que irá escutar as solicitaçõe HHTP POST 
    public ResponseEntity<Object> addUsuario(@Valid @RequestBody Usuario usuario, BindingResult result) {
        if (result.hasErrors()) { //se o Spring validation detectar algum problema nos dados recebidos
            //Retorna Status 400
            return new ResponseEntity<>("Dados da solicitação errados", HttpStatus.BAD_REQUEST);
        }
        if (usuarioRepository.existsByEmail(usuario.getEmail())){ //Verifica se e-mail ja foi cadastrado
            return new ResponseEntity<>("Usuário já cadastrado.", HttpStatus.BAD_REQUEST);
        } else {
            try {
                usuarioRepository.save(usuario); //salva o novo usuário no BD
                return new ResponseEntity<>(usuario, HttpStatus.CREATED);
            } catch (Exception e) {
                //se tiver algum erro retorna status 400
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            }
        }
    }
}
