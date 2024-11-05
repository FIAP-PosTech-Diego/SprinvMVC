package br.com.fiap.locatech.locatech.services;

import br.com.fiap.locatech.locatech.entities.Veiculo;
import br.com.fiap.locatech.locatech.repositories.VeiculoRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;

    public VeiculoService(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    public List<Veiculo> findAllVeiculo(int page, int size){
        int offset = (page - 1) * size;

        return veiculoRepository.findAll(size, offset);

    }

    public Optional<Veiculo> findVeiculoById(Long id){
        return veiculoRepository.findById(id);
    }

    public void saveVeiculo(Veiculo veiculo){
        Integer save = veiculoRepository.save(veiculo);

        Assert.state(save == 1, "Erro ao salvar veiculo " + veiculo.getModelo());

    }

    public void updateVeiculo(Veiculo veiculo, Long id){
        Integer update = veiculoRepository.update(veiculo, id);

        if(update == 0) throw new RuntimeException("Veiculo nao encontrado");

    }

    public void delete(Long id){
        Integer delete = veiculoRepository.delete(id);

        if(delete == 0) throw new RuntimeException("Veiculo nao encontrado");

    }

}
