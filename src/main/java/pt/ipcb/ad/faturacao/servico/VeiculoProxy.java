package pt.ipcb.ad.faturacao.servico;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pt.ipcb.ad.faturacao.model.VeiculoDTO;

@FeignClient(name = "veiculoseletricos")
public interface VeiculoProxy {

    @GetMapping("/veiculos/{marca}/{modelo}")
    VeiculoDTO obterVeiculo(@PathVariable String marca,@PathVariable String modelo);

}
