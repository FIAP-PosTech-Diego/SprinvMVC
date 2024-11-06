package br.com.fiap.locatech.locatech.services;

import br.com.fiap.locatech.locatech.dtos.AluguelDTO;
import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.entities.Veiculo;
import br.com.fiap.locatech.locatech.repositories.AluguelRepository;
import br.com.fiap.locatech.locatech.repositories.AluguelRepository;
import br.com.fiap.locatech.locatech.repositories.VeiculoRepository;
import br.com.fiap.locatech.locatech.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AluguelService {

    private final AluguelRepository aluguelRepository;
    private final VeiculoRepository veiculoRepository;

    public AluguelService(AluguelRepository aluguelRepository, VeiculoRepository veiculoRepository) {
        this.aluguelRepository = aluguelRepository;
        this.veiculoRepository = veiculoRepository;
    }

    public List<Aluguel> findAllAluguel(int page, int size){
        int offset = (page - 1) * size;

        return aluguelRepository.findAll(size, offset);

    }

    public Aluguel findAluguelById(Long id){
        return aluguelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluguel nao encontrado"));
    }

    public void saveAluguel(AluguelDTO dto){

        Integer save = aluguelRepository.save(calculaAluguel(dto));

        Assert.state(save == 1, "Erro ao salvar Aluguel " + dto.pessoaId());

    }

    public void updateAluguel(Aluguel aluguel, Long id){
        Integer update = aluguelRepository.update(aluguel, id);

        if(update == 0) throw new RuntimeException("Aluguel nao encontrado");

    }

    public void delete(Long id){
        Integer delete = aluguelRepository.delete(id);

        if(delete == 0) throw new RuntimeException("Aluguel nao encontrado");

    }

    private Aluguel calculaAluguel(AluguelDTO dto){

        Veiculo veiculo = veiculoRepository.findById(dto.veiculoId())
                .orElseThrow(() -> new RuntimeException("Veiculo nao encontrado"));

        BigDecimal qtdDias = BigDecimal.valueOf(dto.dataFim().getDayOfYear() - dto.dataInicio().getDayOfYear());

        BigDecimal valorTotal = veiculo.getValorDiaria().multiply(qtdDias);

        return new Aluguel(dto, valorTotal);

    }

}
