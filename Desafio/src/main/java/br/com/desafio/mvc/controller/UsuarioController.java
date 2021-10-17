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

import br.com.desafio.mvc.model.Usuario;
import br.com.desafio.mvc.repository.UsuarioRepository;
import br.com.desafio.mvc.service.UsuarioService;
import br.com.desafio.mvcdto.RequisicaoNovoUsuario;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoUsuario requisicao){
		return "usuario/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoUsuario requisicao, BindingResult result) {
		
		if(result.hasErrors()){
			return "usuario/formulario";
		}
		
		Usuario usuario = requisicao.toCargo();
		usuarioRepository.save(usuario);
		
		return "usuario/listar";
	}
	
	@RequestMapping("editar/{id}")
    public String editarUsuario(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuarioRepository.findById(id).get();
        model.addAttribute("usuario", usuario);

        return "usuario/editar";
    }
	
	@RequestMapping("atualizar")
	public String atualiza(Usuario usuario){
	    service.salvar(usuario);
	    return "redirect:usuario/listar";
	}
	
	@RequestMapping("listar")
	public String listar(Model model) {
		List<Usuario> usuario = usuarioRepository.findAll();
		model.addAttribute("usuario", usuario);
		
		return "usuario/listar";
	}
	
}