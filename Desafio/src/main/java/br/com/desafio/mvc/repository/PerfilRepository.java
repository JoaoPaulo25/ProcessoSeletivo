package br.com.desafio.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.mvc.model.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
		
}