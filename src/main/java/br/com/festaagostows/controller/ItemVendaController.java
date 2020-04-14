package br.com.festaagostows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.festaagostows.service.ItemVendaService;

@Controller
@RequestMapping("/itemvenda")
public class ItemVendaController {

	@Autowired
	private ItemVendaService itemVendaService;
	
	
	@RequestMapping("/helloworld")
	public ModelAndView index () {
		ModelAndView modelAndView = new ModelAndView("itemVenda/itemVendaCadastrar");
		return modelAndView;
	}

	
}
