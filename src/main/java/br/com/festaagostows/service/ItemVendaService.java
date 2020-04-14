package br.com.festaagostows.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.festaagostows.model.ItemVenda;
import br.com.festaagostows.model.Produto;
import br.com.festaagostows.repository.ItemVendaRepository;

@Service
public class ItemVendaService {

	@Autowired
	private ItemVendaRepository itemVendaRepository;

	private List<ItemVenda> itensVenda;
	private ItemVenda itemVenda;

	Optional<ItemVenda> opItemVenda;

	public ItemVenda addItemVenda(@Valid Produto produto) {

		produto = aplicaDescontoProduto(produto);
		opItemVenda.get().setProduto(produto);
		itemVenda = opItemVenda.get();
		itensVenda.add(opItemVenda.get());

		itemVenda = itemVendaRepository.save(itemVenda);

		return itemVenda;
	}

	public Produto aplicaDescontoProduto(Produto produto) {

		return produto;
	}
}
