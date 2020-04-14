package br.com.festaagostows.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/venda")
public class VendaController {


	@RequestMapping("/")
	public ModelAndView index () {
		ModelAndView modelAndView = new ModelAndView("venda/venda");
		return modelAndView;
	}
}
