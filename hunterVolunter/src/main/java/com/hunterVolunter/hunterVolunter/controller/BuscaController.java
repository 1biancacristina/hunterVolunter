package com.hunterVolunter.hunterVolunter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/*import org.springframework.web.bind.annotation.PostMapping;
*/import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hunterVolunter.hunterVolunter.repository.ProjetoRepository;

@Controller
public class BuscaController {

	@Autowired
	private ProjetoRepository pr;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView openIndex() {
		ModelAndView mv = new ModelAndView("index");
		return mv;

	}
	
	  @RequestMapping(value = "/", method = RequestMethod.POST) 
	  public ModelAndView pesquisarIndex(@RequestParam("pesquisar")String pesquisar){
	  ModelAndView mv = new ModelAndView("index"); 
	  String mensagem = "Encontramos esses projetos correspondente: " + pesquisar + ", clique na categoria e veja todos!";
	  mv.addObject("projetos",pr.findByName(pesquisar)); 
	  mv.addObject("mensagem",mensagem); 
	  return mv; }



			@RequestMapping( "/contato" )
			public ModelAndView openContato(){
				return new ModelAndView("contato/contato");
			}
}