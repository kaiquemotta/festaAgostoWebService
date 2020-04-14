package br.com.festaagostows.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.festaagostows.model.Produto;
import br.com.festaagostows.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

	Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	ProdutoService produtoService;

	@GetMapping("/index")
	public ModelAndView home() {
		return new ModelAndView("/index");
	}

	private List<Produto> produtos;


	@RequestMapping("/")
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("produto/produto.html");
		modelAndView.addObject("produto", produtoService.list());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Produto produto, BindingResult result,
			RedirectAttributes redicrectAttributes) {
		if (result.hasErrors()) {
			return new ModelAndView("produto/produto");
		}
		produtoService.save(produto);
		redicrectAttributes.addFlashAttribute("sucesso", "Cadastro com sucesso");
		return new ModelAndView("produto/produto");
	}

	@RequestMapping(path = { "/edit", "/edit/{id}" })
	public String editEmployeeById(Model model, @PathVariable("id") Optional<Long> id) {
		Optional<Produto> OpProduto = null;
		if (id.isPresent()) {
			OpProduto = produtoService.getProdutoById(id.get());
			model.addAttribute("produto", OpProduto);
		} else {
			model.addAttribute("produto", new Produto());
		}
		return "produto/editarProduto";
	}

	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Produto> getOne(Long Id)
	{
		return produtoService.getOne(Id);
	}

	@RequestMapping(value = "/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Produto produto){
		produtoService.update(produto);
		return "produto";
	}

}
