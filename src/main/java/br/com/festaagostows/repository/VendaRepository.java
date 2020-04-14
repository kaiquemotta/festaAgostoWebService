package br.com.festaagostows.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.festaagostows.model.Venda;

/**
 * VendaRepository
 */
@Repository
public interface VendaRepository extends JpaRepository <Venda,Long> {
    
}