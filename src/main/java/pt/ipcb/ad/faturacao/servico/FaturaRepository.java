package pt.ipcb.ad.faturacao.servico;


import org.springframework.data.jpa.repository.JpaRepository;
import pt.ipcb.ad.faturacao.model.Fatura;

public interface FaturaRepository extends JpaRepository<Fatura, Long> {

}
