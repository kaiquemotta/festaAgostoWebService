package br.com.festaagostows.api;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.festaagostows.model.SituacaoVenda;
import br.com.festaagostows.model.TipoVenda;
import br.com.festaagostows.model.Venda;
import br.com.festaagostows.service.VendaService;
import br.com.festaagostows.util.Response;

/**
 * VendaApiController
 */
@RestController
@RequestMapping("/api/venda")
public class VendaApiController {
    @Autowired 
    private VendaService vendaService;
    private static final Logger LOG = LoggerFactory.getLogger(VendaApiController.class);

    
    @PostMapping("/add")
    public ResponseEntity<Response<Venda>> register(@Valid @RequestBody final Venda venda) {
        final Response<Venda> response = new Response<>();
        try {
            if (venda != null) {
                if(venda.getSituacao()!= null  && venda.getTipoVenda()!= null){
                    vendaService.save(venda);
                    response.setData(venda);
                }else{
                    venda.setSituacao(SituacaoVenda.EM_ABERTO);
                    venda.setTipoVenda(TipoVenda.PEDIDO);
                    vendaService.save(venda);
                    response.setData(venda); 
                }          
            }
            LOG.info("Venda registrada com sucesso: " + venda.toString());
            return ResponseEntity.ok(response);
        } catch (final Exception e) {

            response.getErrors().add("Registro invalido");
            final StringBuilder errosBuilder = new StringBuilder();
            response.getErrors().stream().forEach(s -> {
                errosBuilder.append("Erros: ").append(s).append(" ");
            });
            LOG.info(errosBuilder.toString());
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
        }

    }
    
}