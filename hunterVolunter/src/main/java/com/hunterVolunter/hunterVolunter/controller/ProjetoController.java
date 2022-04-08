package com.hunterVolunter.hunterVolunter.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hunterVolunter.hunterVolunter.models.Projeto;
import com.hunterVolunter.hunterVolunter.repository.ProjetoRepository;

@SpringBootApplication
@Controller
public class ProjetoController {

	@Autowired
	private ProjetoRepository pr;

	@GetMapping(value = "/projeto")
	public String gravarProjeto() {
		return "projeto/projeto";

	}

	@RequestMapping(value = "/projeto", method = RequestMethod.POST)
	public String salvarProjeto(Projeto projeto) {
		pr.save(projeto);
		return "redirect:/projeto";

	}

	@RequestMapping("/projetos")
	public ModelAndView listarProjeto() {
		ModelAndView mv = new ModelAndView("projeto/listarProjeto");
		Iterable<Projeto> projetos = pr.findAll();
		mv.addObject("projetos", projetos);
		return mv;

	}

	@RequestMapping("/deletarProjeto")
	public String deletarProjeto(long codigo) {
		Projeto projeto = pr.findByCodigo(codigo);
		pr.delete(projeto);
		return "redirect:/projetos";
	}

	@RequestMapping(value = "updateProjeto", method = RequestMethod.GET)
	public ModelAndView atualizarProjeto(long codigo)  {
		Projeto projeto = pr.findByCodigo(codigo);
		ModelAndView mv = new ModelAndView("projeto/projetoUpdate");
		mv.addObject("projeto", projeto);
		return mv;
	}

	@RequestMapping(value = "updateProjeto", method = RequestMethod.POST)
	public String updateProjeto(@Valid Projeto projeto, BindingResult result, RedirectAttributes attributes) {
		pr.save(projeto);
		attributes.addFlashAttribute("sucess", "Atualizado com sucesso");
		
		/*
		 * long codigoLong = projeto.getCodigo(); String codigo = "" + codigoLong;
		 */
		return "redirect:/projetos";
	}

}
