package br.com.festaagostows.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.festaagostows.model.Produto;
import br.com.festaagostows.service.ProdutoService;
import br.com.festaagostows.util.Response;

@RestController
@RequestMapping("/api/produto")
public class ProdutoApiController {

    private static final Logger LOG = LoggerFactory.getLogger(ProdutoApiController.class);

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Response<Produto>> register(@Valid @RequestBody Produto produto) {
        Response<Produto> response = new Response<>();
        try {
            if (produto != null) {
                this.produtoService.save(produto);
                response.setData(produto);
            }
            LOG.info("O produto foi salvo com sucesso: " + produto.toString());
            return ResponseEntity.ok(response);
        } catch (Exception e) {

            response.getErrors().add("Registro invalido");
            StringBuilder errosBuilder = new StringBuilder();
            response.getErrors().stream().forEach(s -> {
                errosBuilder.append("Erros: ").append(s).append(" ");
            });
            LOG.info(errosBuilder.toString());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

    }
    
    @GetMapping("/listar")
    public ResponseEntity<List<Produto>> list() {
        LOG.debug("list()");

        final List<Produto> list = produtoService.list();
        if (list.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(list);
    }



}
