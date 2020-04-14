package br.com.festaagostows.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.festaagostows.model.Venda;
import br.com.festaagostows.repository.VendaRepository;

/**
 * VendaService
 */
@Service
public class VendaService {

    @Autowired
    private VendaRepository vendaRepository;

    public Venda save(Venda venda) {
        vendaRepository.save(venda);
        return venda;
    }

}