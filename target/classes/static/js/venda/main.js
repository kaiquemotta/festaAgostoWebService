
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


    function renderTable(json) {
      // busca o template salvo na página
      var template = $('#template').html();
  
      // renderiza o template com o json
      var rendered = Mustache.render(template, json);
  
      // insere o HTML final dentro de um elemento
      $('#target'
      
      
      ).html(rendered);
  }



    $("select").on("change", function() {
      var x = document.getElementById("produtoSelect").selectedIndex;
      var y = document.getElementById("produtoSelect").options;
     // alert("Index: " + y[x].id + " is " + y[x].text);
      console.log(y[x].text);
      $.ajax({
        type: "GET",
        url: "/api/venda/getDesc?desc="+y[x].text+"",
        data: $('#produto').serialize(),
				datatype: 'json',
        contentType: "application/json; charset=utf-8",

        success: function (data) {
          console.log(JSON.stringify(data));
          table(data)
        },
        error: function() {
        }
      });
    
      })

      

      // chamar tabela na requisao ajax e adicionar + 1 item 
      function table (json) {

            tr = $('<tr/>');
            tr.append("<td class = 'id'>" + json.id + "</td>");
            tr.append("<td>" + json.nome + "</td>");
            tr.append("<td class = 'preco'> " + json.preco + "</span></td>");
            tr.append("<td >"+"<input type = 'number' class = 'col-3 btnSelect inpute' >"+"</td>");
            tr.append("<td id = 'subtotal'>"+json.preco+"</td>");
            tr.append("<td>"+'info'+"</td>");
            tr.append("<td> <a type='button' class='btn-floating btn-sm red' data-toggle='modal' data-target='#modalConfirmDelete'><i class='fas fa-trash' aria-hidden='true'></i></a></td>")
          
            $('table').append(tr);    
            
    };

    $(document).ready(function(){

      $("#tabelaitem").on('click', '.btnSelect', function() {
    // get the current row
    var currentRow = $(this).closest("tr");
  
    var col1 = currentRow.find(".id").html(); // get current row 1st table cell TD value
    var preco = currentRow.find(".preco").html(); // get current row 2nd table cell TD value
    var quantidade = $(this).closest('tr').find('input').val();

    console.log(quantidade);

    var data = preco + "\n" + quantidade;
  
    alert(data);
  });
  });
    function addSub() {
      

      var td = document.querySelectorAll('td');

      
        var linha = $(this).parent().value;
        console.log(linha);
        var quantidade =  document.getElementById("quantidade").value ;
        var preco =  document.getElementById("preco").innerHTML ;
        document.getElementById("subtotal").innerHTML = subTotal;
        console.log(quantidade);
        console.log(preco);
      
      };
    



    $(".amount, .price").on("blur keyup",function(){ //register o evento de blur e keyup
    const tr = $(this).parent().parent(); //andar dois elementos para cima até ao <tr>

    const quant = parseInt(tr.find('.amount').val()); //ir buscar a quantidade com base no <tr>
    const valor = parseInt(tr.find('.price').val()); //ir buscar o valor com base no <tr>

    if (!isNaN(quant) && !isNaN(valor)){ //ver se ambos existem
      tr.find('.total').html("R$ " + (quant * valor)); //aplicar o calculo no total
    }
});
       
//SELECT SEARCH
$('.selectVenda').select2({
	 placeholder: "Selecione um Produto",
	  allowClear: true,
     maximumResultsForSearch: 1 // at least 20 results must be displayed
});
  
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