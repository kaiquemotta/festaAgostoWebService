package br.com.festaagostows.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "venda")
public class Venda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate dataVenda;
	@OneToMany(mappedBy = "venda")
	@JsonIgnore
	private List <ItemVenda> itensVenda;
	private Double valorTotal;
	@Enumerated(value = EnumType.STRING) 
	private TipoVenda tipoVenda;
	@Enumerated(value = EnumType.STRING) 
	private  SituacaoVenda situacao;
	private Integer numeroChamada ;
	
	public Long getId() {
		return id;
	}
	public void setId(final Long id) {
		this.id = id;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(final LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(final List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(final Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public TipoVenda getTipoVenda() {
		return tipoVenda;
	}

	public void setTipoVenda(final TipoVenda tipoVenda) {
		this.tipoVenda = tipoVenda;
	}

	public SituacaoVenda getSituacao() {
		return situacao;
	}

	public void setSituacao(final SituacaoVenda situacao) {
		this.situacao = situacao;
	}

	public Integer getNumeroChamada() {
		return numeroChamada;
	}

	public void setNumeroChamada(Integer numeroChamada) {
		this.numeroChamada = numeroChamada;
	}
	
}
