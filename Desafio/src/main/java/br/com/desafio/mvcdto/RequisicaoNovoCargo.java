package br.com.desafio.mvcdto;

import javax.validation.constraints.NotBlank;

import br.com.desafio.mvc.model.Cargo;

public class RequisicaoNovoCargo {
	
	@NotBlank
	private String nomeCargo;
	
	@NotBlank
	private String descricao;
	
	public String getNomeCargo() {
		return nomeCargo;
	}
	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Cargo toCargo() {
		Cargo cargo = new Cargo();
		
		cargo.setNome(nomeCargo);
		cargo.setDescricao(descricao);
		
		return cargo;
	}
}
