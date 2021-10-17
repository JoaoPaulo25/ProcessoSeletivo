package br.com.desafio.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.desafio.mvc.model.Perfil;
import br.com.desafio.mvc.repository.PerfilRepository;

@Service
public class PerfilService {

    @Autowired
    private PerfilRepository repository;

    public void salvar(Perfil perfil) {
        repository.save(perfil);
    }
}