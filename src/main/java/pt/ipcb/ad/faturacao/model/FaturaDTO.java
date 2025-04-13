package pt.ipcb.ad.faturacao.model;

public class FaturaDTO {
    private String marca;
    private String modelo;
    private Double kmp;
    private Double kc;

    private Double faturaMensal;
    private Double consumoMedio;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Double getKmp() {
        return kmp;
    }

    public void setKmp(Double kmp) {
        this.kmp = kmp;
    }

    public Double getKc() {
        return kc;
    }

    public void setKc(Double kc) {
        this.kc = kc;
    }

    public Double getFaturaMensal() {
        return faturaMensal;
    }

    public void setFaturaMensal(Double faturaMensal) {
        this.faturaMensal = faturaMensal;
    }

    public Double getConsumoMedio() {
        return consumoMedio;
    }

    public void setConsumoMedio(Double consumoMedio) {
        this.consumoMedio = consumoMedio;
    }
}
