
$('document').ready(function () {
    $('.table .eBtn').on('click', function (event) {

        event.preventDefault();

        var href = $(this).attr('href');

        $.get(href,function (produto) {
            $('#id-produto').val(produto.id);
            $('#nome-produto').val(produto.nome);
            $('#preco-produto').val(produto.preco);
            $('#descricao-produto').val(produto.descricaoProduto);
        })
        $('#modalEditar').modal();
    });
});

//Todos os exemplos estao dentro da documentação .DataTable
$(function () {
    $('#paginacaoProduto').DataTable({
        "language": {
            "info": "Exibindo _START_ de _END_ no total de _TOTAL_ registros",
            "emptyTable": "Não há produtos nessa venda.",
            "infoFiltered": " (filtragem de _MAX_ registros)",
            "paginate": {
                "previous": "Anterior",
                "next": "Proximo"
            }
        },
        "paging": true,
        "lengthChange": false,
        "searching": true,
        "ordering": true,
        "info": true,
        "autoWidth": true,
    });
});