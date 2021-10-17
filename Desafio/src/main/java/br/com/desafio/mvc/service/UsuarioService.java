package br.com.desafio.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.mvc.model.Usuario;
import br.com.desafio.mvc.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public void salvar(Usuario usuario) {
        repository.save(usuario);
    }
}