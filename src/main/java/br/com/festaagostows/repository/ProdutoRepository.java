package br.com.festaagostows.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.festaagostows.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Long> {
	
	@Query(value = "SELECT * FROM produto p WHERE p.nome LIKE %:keyword%" ,nativeQuery = true)
	List<Produto> findByKeyWorld(@Param("keyword")String keyword);

}
