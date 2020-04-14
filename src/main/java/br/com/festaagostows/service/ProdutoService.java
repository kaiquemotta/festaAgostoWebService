package br.com.festaagostows.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.festaagostows.model.Produto;
import br.com.festaagostows.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> list() {
		return this.produtoRepository.findAll();
	}

	public Produto save(Produto produto) {
		if (produto != null) {
			this.produtoRepository.save(produto);
		}
		return produto;
	}

	public Produto getProdutoId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Produto> getProdutoById(Long id) {	
		Optional<Produto> p = produtoRepository.findById(id);
		return p;
	}

	public List<Produto> findByKeyword(String keyword) {
		return produtoRepository.findByKeyWorld(keyword);
	}

	public Optional<Produto> getOne(Long id) {
		Optional<Produto> p = produtoRepository.findById(id);
		return p;
	}

	public void update(Produto produto){
		produtoRepository.save(produto);
	}
}
