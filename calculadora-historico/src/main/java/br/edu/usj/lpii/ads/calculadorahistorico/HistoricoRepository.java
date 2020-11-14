package br.edu.usj.lpii.ads.calculadorahistorico;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface HistoricoRepository extends CrudRepository<Historico, Long> {
    List<Historico> findAll();
    

}
