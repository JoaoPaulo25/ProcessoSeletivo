package br.com.desafio.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafio.mvc.model.Cargo;
import br.com.desafio.mvc.repository.CargoRepository;

@Service
public class CargoService {

    @Autowired
    private CargoRepository repository;

    public void salvar(Cargo cargo) {
        repository.save(cargo);
    }
}