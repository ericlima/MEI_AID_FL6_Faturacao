package pt.ipcb.ad.faturacao.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pt.ipcb.ad.faturacao.model.Fatura;
import pt.ipcb.ad.faturacao.model.FaturaDTO;
import pt.ipcb.ad.faturacao.model.VeiculoDTO;
import pt.ipcb.ad.faturacao.servico.FaturaRepository;
import pt.ipcb.ad.faturacao.servico.VeiculoProxy;

@RestController
public class FaturaController {

    private final FaturaRepository faturaRepository;

    private final VeiculoProxy veiculoProxy;

    public FaturaController(VeiculoProxy veiculoProxy, FaturaRepository faturaRepository) {
        this.veiculoProxy = veiculoProxy;
        this.faturaRepository = faturaRepository;
    }

    private FaturaDTO calculoFatura(String marca, String modelo, Double Kmp, Double Kc) {
        VeiculoDTO veiculo = veiculoProxy.obterVeiculo(marca, modelo);
        //Fatura= 100 x CapBateriakW/Autonomia x KmP/100 x KC/100
        //Consumo Médio = 100 x CapBateriakW/Autonomia
        FaturaDTO fatura = new FaturaDTO();
        fatura.setMarca(veiculo.getMarca());
        fatura.setModelo(veiculo.getModelo());
        fatura.setKmp(Kmp);
        fatura.setKc(Kc);

        Double fm = 100 * (veiculo.getBateria()/veiculo.getAutonomia()) * (Kmp/100) * (Kc/100);
        Double cm = 100 * (veiculo.getBateria()/veiculo.getAutonomia());

        fatura.setFaturaMensal(fm);
        fatura.setConsumoMedio(cm);

        return fatura;
    }

    @GetMapping(value = "/faturas/{marca}/{modelo}/{KmP}/{KC}")
    public FaturaDTO testa(
            @PathVariable String marca,
            @PathVariable String modelo,
            @PathVariable Double KmP,
            @PathVariable Double KC
    ) {
        return calculoFatura(marca, modelo, KmP, KC);
    }

    @PostMapping(value = "/faturas")
    public FaturaDTO emite(@RequestBody FaturaDTO faturaDTO) {
        FaturaDTO calculo = calculoFatura(faturaDTO.getMarca(), faturaDTO.getModelo(), faturaDTO.getKmp(), faturaDTO.getKc());
        Fatura fatura = new Fatura();
        fatura.setMarca(calculo.getMarca());
        fatura.setModelo(calculo.getModelo());
        fatura.setKmp(calculo.getKmp());
        fatura.setKc(calculo.getKc());
        fatura.setFaturaMensal(calculo.getFaturaMensal());
        fatura.setConsumoMedio(calculo.getConsumoMedio());

        fatura.setId(null);

        faturaRepository.save(fatura);
        return calculo;
    }

}
