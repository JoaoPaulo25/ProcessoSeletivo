package br.com.desafio.mvc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.desafio.mvc.model.Perfil;
import br.com.desafio.mvc.repository.PerfilRepository;
import br.com.desafio.mvc.service.PerfilService;
import br.com.desafio.mvcdto.RequisicaoNovoPerfil;

@Controller
@RequestMapping("perfil")
public class PerfilController {
	
	@Autowired
	private PerfilRepository perfilRepository;
	
	@Autowired
	private PerfilService service;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoPerfil requisicao){
		return "perfil/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoPerfil requisicao, BindingResult result) {
		
		if(result.hasErrors()){
			return "perfil/formulario";
		}
		
		Perfil perfil = requisicao.toPerfil();
		perfilRepository.save(perfil);
		
		return "perfil/listar";
	}
	
	@RequestMapping("editar/{id}")
    public String editarPerfil(@PathVariable("id") Long id, Model model) {
        Perfil perfil = perfilRepository.findById(id).get();
        model.addAttribute("perfil", perfil);

        return "perfil/editar";
    }
	
	@RequestMapping("atualizar")
	public String atualiza(Perfil perfil){
	    service.salvar(perfil);
	    return "redirect:perfil/listar";
	}
	
	@RequestMapping("listar")
	public String listar(Model model) {
		List<Perfil> perfil = perfilRepository.findAll();
		model.addAttribute("perfil", perfil);
		
		return "perfil/listar";
	}
	
}
