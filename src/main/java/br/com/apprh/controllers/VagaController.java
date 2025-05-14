package br.com.apprh.controllers;

import jakarta.validation.Valid;

// Usado para injeção de dependência automática de componentes (como serviços ou repositórios).
import org.springframework.beans.factory.annotation.Autowired;

// Responsável por tratar requisições HTTP e retornar views.
import org.springframework.stereotype.Controller;

// Captura os erros de validação resultantes da anotação @Valid.
import org.springframework.validation.BindingResult;

// Permite extrair variáveis da URL.
import org.springframework.web.bind.annotation.PathVariable;

// Define o mapeamento de URLs para métodos do controller.
import org.springframework.web.bind.annotation.RequestMapping;

// Enum para especificar o tipo de método HTTP no @RequestMapping (ex: GET, POST, etc.).
import org.springframework.web.bind.annotation.RequestMethod;

// Objeto que combina dados (model) com a view a ser renderizada.
import org.springframework.web.servlet.ModelAndView;

// Usado para passar atributos durante redirecionamento (redirect), como mensagens de sucesso/erro.
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.apprh.model.Candidato;
import br.com.apprh.model.Vaga;
import br.com.apprh.repository.CandidatoRepository;
import br.com.apprh.repository.VagaRepository;

@Controller
public class VagaController {
	
	private VagaRepository vr;
	private CandidatoRepository cr;
	
	
	// Exibe o formulário para cadastrar uma vaga.
	// CADASTRA VAGA
	@RequestMapping(value = "/cadastrarVaga", method = RequestMethod.GET)
	public String form() {
		return "vaga/formVaga";
	}
	
	@RequestMapping(value = "/cadastrarVaga", method = RequestMethod.POST)
	public String form(@Valid Vaga vaga, BindingResult result, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos...");
			return "redirect:/cadastrarVaga";
		}
		
		vr.save(vaga);
		attributes.addFlashAttribute("mensagem", "Vaga cadastrada com sucesso!");
		
		return "redirect:/cadastrarVaga";
	}
	
}
