package br.com.desafio.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.mvc.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
		
}