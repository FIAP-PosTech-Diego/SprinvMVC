package br.com.fiap.locatech.locatech.repositories;

import br.com.fiap.locatech.locatech.entities.Aluguel;

import java.util.List;
import java.util.Optional;

public interface AluguelRepository {

    Optional<Aluguel> findById(Long id);

    List<Aluguel> findAll(int size, int offset);

    Integer save(Aluguel Aluguel);

    Integer update(Aluguel Aluguel, Long id);

    Integer delete(Long id);

}
