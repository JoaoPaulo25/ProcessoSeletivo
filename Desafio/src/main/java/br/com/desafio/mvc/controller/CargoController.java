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

import br.com.desafio.mvc.model.Cargo;
import br.com.desafio.mvc.repository.CargoRepository;
import br.com.desafio.mvc.service.CargoService;
import br.com.desafio.mvcdto.RequisicaoNovoCargo;

@Controller
@RequestMapping("cargo")
public class CargoController {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	@Autowired
	private CargoService service;
	
	@GetMapping("formulario")
	public String formulario(RequisicaoNovoCargo requisicao){
		return "cargo/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@Valid RequisicaoNovoCargo requisicao, BindingResult result) {
		
		if(result.hasErrors()){
			return "cargo/formulario";
		}
		
		Cargo cargo = requisicao.toCargo();
		cargoRepository.save(cargo);
		
		return "cargo/listar";
	}
	
	@RequestMapping("editar/{id}")
    public String editarCargo(@PathVariable("id") Long id, Model model) {
        Cargo cargo = cargoRepository.findById(id).get();
        model.addAttribute("cargo", cargo);

        return "cargo/editar";
    }
	
	@RequestMapping("atualizar")
	public String atualiza(Cargo cargo){
	    service.salvar(cargo);
	    return "redirect:cargo/listar";
	}
	
	@RequestMapping("listar")
	public String listar(Model model) {
		List<Cargo> cargo = cargoRepository.findAll();
		model.addAttribute("cargo", cargo);
		
		return "cargo/listar";
	}
}
