package br.com.festaagostows.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.festaagostows.model.Produto;
import br.com.festaagostows.model.Venda;
import br.com.festaagostows.repository.ProdutoRepository;
import br.com.festaagostows.repository.VendaRepository;

/**
 * VendaService
 */
@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    @Autowired 
    private ProdutoRepository produtoRepository;

    public Venda save(final Venda venda) {
        vendaRepository.save(venda);
        return venda;
    }

	public Optional<Produto> getDesc(String desc) {
        return produtoRepository.findByDesc(desc);
	}

}