package com.hunterVolunter.hunterVolunter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hunterVolunter.hunterVolunter.models.Projeto;
import com.hunterVolunter.hunterVolunter.repository.ProjetoRepository;


@Controller
public class ProjetoController {
	
	@Autowired
	private ProjetoRepository pr;
	
	
	@GetMapping(value = "/projeto")
	public String form() {
	return "projeto/projeto";
		
	}
	
	@RequestMapping(value = "/projeto", method = RequestMethod.POST)	
	public String form(Projeto projeto) { 
	pr.save(projeto);
	return "redirect:/projeto";
		
	}
	
	@RequestMapping("/projetos")
	public ModelAndView listarProjeto() {
		ModelAndView mv = new ModelAndView("projeto/listarProjeto");
		Iterable<Projeto>projetos = pr.findAll();
		mv.addObject("projetos", projetos);
		return mv;
		
	}
	
	@RequestMapping("/deletarProjeto")
	public String deletarProjeto(long codigo) {
		Projeto projeto = pr.findByCodigo(codigo);
		pr.delete(projeto);
		return "redirect:/projetos";
	}
	
	
	@RequestMapping(value="/updateprojeto",method = RequestMethod.GET) public
	  ModelAndView atualizarProjeto(long codigo) { Projeto projeto =
	  pr.findByCodigo(codigo); ModelAndView modelAndView = new
	  ModelAndView("/projeto/projeto-edit"); modelAndView.addObject("projeto",
	  projeto); return modelAndView; }
	 

	@RequestMapping(value = "/updateprojeto", method = RequestMethod.POST)
	public String atualizarProjeto(@Valid Projeto projeto, BindingResult result, RedirectAttributes attributes) {
		pr.save(projeto);
		attributes.addFlashAttribute("Atualizado com sucesso");
		
		
		return "redirect:/";
	}


}



