package br.com.desafio.mvcdto;

import java.time.LocalDate;

import br.com.desafio.mvc.model.Usuario;

public class RequisicaoNovoUsuario {
	
	private String nomeUsuario;
	private String cpf;
	private LocalDate dataNasc;
	private char sexo;
	private String cargo;
	private String perfil;
	private LocalDate criacao;
	

	public LocalDate getCriacao() {
		return criacao;
	}
	public void setCriacao(LocalDate criacao) {
		this.criacao = criacao;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public Usuario toCargo() {
		Usuario usuario = new Usuario();
		
		usuario.setNome(nomeUsuario);
		usuario.setCpf(cpf);
//		usuario.setDataNascimento(dataNasc);
		usuario.setSexo(sexo);
		usuario.setCargo(cargo);
		usuario.setPerfil(perfil);
		usuario.setCriacao(LocalDate.now());
		
		return usuario;
	}
	
	

}
