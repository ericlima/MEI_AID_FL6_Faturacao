package pt.ipcb.ad.faturacao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorRest {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/instancias-servico/{nomeservico}")
    public List<ServiceInstance>
    getAllInstancesServicoByNomeMicroservico
            (@PathVariable String nomeservico) {
        return this.discoveryClient.getInstances(nomeservico);
    }

    @GetMapping(value = "/servicos")
    public List<String> getAllServicos() {
        return this.discoveryClient.getServices();
    }

}
