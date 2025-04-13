package pt.ipcb.ad.faturacao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private Double kmp;
    private Double kc;

    private Double faturaMensal;
    private Double consumoMedio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarcaç() {
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
