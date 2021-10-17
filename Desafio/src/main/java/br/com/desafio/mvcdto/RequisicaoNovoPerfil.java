package br.com.desafio.mvcdto;

import javax.validation.constraints.NotBlank;

import br.com.desafio.mvc.model.Perfil;

public class RequisicaoNovoPerfil {
	
	@NotBlank
	private String nomePerfil;

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}

	public Perfil toPerfil() {
		Perfil perfil = new Perfil();
		
		perfil.setNome(nomePerfil);
		
		return perfil;
	}
	
}
