
$(document).ready(function () {
        $.ajax({
            type: "get",
            url: "/api/produto/listar",
            data: { Produto: $("#selectVenda").val() },
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            success: function (obj) {
                if (obj != null) {
                    var data = obj;
                    var selectbox = $('.selectVenda');
                    selectbox.find('option').remove();
                    $.each(data, function (i, d) {
                        $('<option>').val(d.id).text(d.nome).appendTo(selectbox);
                    });
                }
            }
        });

    });
       
//SELECT SEARCH
$('.selectVenda').select2({
	 placeholder: "Selecione um Produto",
	  allowClear: true,
     maximumResultsForSearch: 1 // at least 20 results must be displayed
});


$("select").on("change", function() {
    var id = $(this).prop("id");  // pega o id do select clicado
    var val= $(this).val();       // pega o valor do option selecionado
    

    console.log("ID:"+id+" - VALOR:"+val);
  })

  
//Listar itens Venda
  function listar(){

    var idvenda = $("#tabelaitemvenda").val();
    $.ajax({
      type: "POST",
      url: "/api/itemvenda/listar",
      data: {idvenda:idvenda},
      success: function (result) {
        $("#divitens").html(result);
        table();
      },
      error: function() {
      }
    });
  }

  function AdicionaProdutoVenda(idvenda,idproduto,quantidade){

    $.ajax({
  type: "POST",
  url: "/DTO/call/venda/adicionaitemvenda.php",
 data: {idvenda:idvenda,idproduto:idproduto,quantidade:quantidade},
  success: function (result) {


  var table = $("#tabelaitem").dataTable();
        table.dataTable().fnDestroy();
        listarTotal();
        listar();


  },
  error: function() {
  }
});
 }