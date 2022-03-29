package com.hunterVolunter.hunterVolunter.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hunterVolunter.hunterVolunter.models.Entidade;
import com.hunterVolunter.hunterVolunter.models.Projeto;
/*import com.hunterVolunter.hunterVolunter.models.Projeto;
import com.hunterVolunter.hunterVolunter.repository.ProjetoRepository;
import org.springframework.web.bind.annotation.PathVariable;*/
import com.hunterVolunter.hunterVolunter.repository.EntidadeRepository;
import com.hunterVolunter.hunterVolunter.repository.ProjetoRepository;


@Controller
public class EntidadeController {

	@Autowired
	private EntidadeRepository er;
	
	@Autowired
	private ProjetoRepository pr;

	/*
	 * @Autowired private ProjetoRepository pr;
	 */

	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public String form() {
		return "entidade/cadastro";
	}

	@RequestMapping(value = "/cadastro", method = RequestMethod.POST)
	public String form(@Valid Entidade entidade, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("Reveja os campos!");
			return "redirect:/cadastro";
		}

		er.save(entidade);
		attributes.addFlashAttribute("Cadastrado com sucesso!");
		return "redirect:/cadastro";
	}

	/*
	 * @RequestMapping(value = "/projeto", method = {RequestMethod.GET,
	 * RequestMethod.POST}) public String form(@Valid Projeto projeto, BindingResult
	 * result, RedirectAttributes attributes, String identificacao) {
	 * 
	 * Entidade entidade = er.findByIdentificacao(identificacao);
	 * projeto.setEntidade(entidade); pr.save(projeto);
	 * attributes.addFlashAttribute("Cadastrado com sucesso"); return
	 * "redirect:/projeto"; }
	 * 
	 */
	
	@GetMapping("/login")
	public String log() {
		return "login/login";
	}
	
	@PostMapping("/logar")
	public String logar(Model model, Entidade entidade) {
		Entidade usuario = this.er.Login(entidade.getEmail(), entidade.getSenha());
		if(usuario != null) {
			return "redirect:/";
		}
	model.addAttribute("erro", "Usuário ou Senha inválidos");
		return "login/login";
	}
	
	@RequestMapping(value = "/perfil", method = RequestMethod.POST)	
	public String form(Projeto projeto) { 
	pr.save(projeto);
	return "redirect:/perfil";
		
	}
	
	@RequestMapping("/perfil")
	public ModelAndView listarProjeto() {
		ModelAndView mv = new ModelAndView("perfil/perfil");
		Iterable<Projeto>projetos = pr.findAll();
		mv.addObject("projetos", projetos);
		return mv;
		
	}
	
}
