package br.com.desafio.mvc.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafio.mvc.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
	
	Optional<Cargo> findById(Long id);
	
}
