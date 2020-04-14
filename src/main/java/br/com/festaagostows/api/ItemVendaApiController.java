package br.com.festaagostows.api;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.festaagostows.model.ItemVenda;
import br.com.festaagostows.model.Produto;
import br.com.festaagostows.service.ItemVendaService;
import br.com.festaagostows.util.Response;

@Controller
@RequestMapping("api/itemvenda")
public class ItemVendaApiController {

    @Autowired
    private ItemVendaService itemVendaService;

    private static final Logger LOG = LoggerFactory.getLogger(ItemVendaApiController.class);

    @RequestMapping("/helloworld")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("itemVenda/itemVendaCadastrar");
        return modelAndView;
    }

    @PostMapping("/adicionaritemcarinho")
    public ResponseEntity<Response<ItemVenda>> adicionaItemCarinho(@Valid @RequestBody Produto produto) {
        Response<ItemVenda> response = new Response<ItemVenda>();
        ItemVenda itemVenda = new ItemVenda();
        if (produto != null) {
            try {
                itemVenda = itemVendaService.addItemVenda(produto);
                response.setData(itemVenda);
                return ResponseEntity.ok(response);
            } catch (Exception e) {
                System.err.println(e);
                response.getErrors().add("Erro ao Adiconar ao carrinho");
                StringBuilder errosBuilder = new StringBuilder();
                response.getErrors().stream().forEach(s -> {
                    errosBuilder.append("Erros: ").append(s).append(" ");
                });
                LOG.info(errosBuilder.toString());
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }
        }
        response.getErrors().add("Produto Nullo");
        StringBuilder errosBuilder = new StringBuilder();
        response.getErrors().stream().forEach(s -> {
            errosBuilder.append("Erros: ").append(s).append(" ");
        });
        LOG.info(errosBuilder.toString());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

}
