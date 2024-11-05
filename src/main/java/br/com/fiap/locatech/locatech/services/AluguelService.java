package br.com.fiap.locatech.locatech.services;

import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.repositories.AluguelRepository;
import br.com.fiap.locatech.locatech.repositories.AluguelRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;

    public AluguelService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public List<Aluguel> findAllAluguel(int page, int size){
        int offset = (page - 1) * size;

        return aluguelRepository.findAll(size, offset);

    }

    public Optional<Aluguel> findAluguelById(Long id){
        return aluguelRepository.findById(id);
    }

    public void saveAluguel(Aluguel aluguel){
        Integer save = aluguelRepository.save(aluguel);

        Assert.state(save == 1, "Erro ao salvar Aluguel " + aluguel.getId());

    }

    public void updateAluguel(Aluguel aluguel, Long id){
        Integer update = aluguelRepository.update(aluguel, id);

        if(update == 0) throw new RuntimeException("Aluguel nao encontrado");

    }

    public void delete(Long id){
        Integer delete = aluguelRepository.delete(id);

        if(delete == 0) throw new RuntimeException("Aluguel nao encontrado");

    }

}
