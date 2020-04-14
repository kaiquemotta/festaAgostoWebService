package br.com.festaagostows.model;

import java.time.LocalDate;

/**
 * VendaPagamentoModel
 */
public  class VendaPagamentoModel {

    private int venda = 0;
    private int pagamento = 0;
    private int parcela = 0;
    private double valor = 0;
    private Integer caixaCodigo = 0;
    private Integer caixaFilial = 0;
    private String caixaUsuario = "";
    private double desconto =0;
    private double valorTotal =0;
    private String observacao;
    private LocalDate dataPagamento;


    public int getVenda() {
        return venda;
    }

    public void setVenda(int venda) {
        this.venda = venda;
    }

    public int getPagamento() {
        return pagamento;
    }

    public void setPagamento(int pagamento) {
        this.pagamento = pagamento;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Integer getCaixaCodigo() {
        return caixaCodigo;
    }

    public void setCaixaCodigo(Integer caixaCodigo) {
        this.caixaCodigo = caixaCodigo;
    }

    public Integer getCaixaFilial() {
        return caixaFilial;
    }

    public void setCaixaFilial(Integer caixaFilial) {
        this.caixaFilial = caixaFilial;
    }

    public String getCaixaUsuario() {
        return caixaUsuario;
    }

    public void setCaixaUsuario(String caixaUsuario) {
        this.caixaUsuario = caixaUsuario;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    

    
}