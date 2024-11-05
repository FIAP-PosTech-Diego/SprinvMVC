package br.com.fiap.locatech.locatech.services;

import br.com.fiap.locatech.locatech.entities.Pessoa;
import br.com.fiap.locatech.locatech.repositories.PessoaRepository;
import br.com.fiap.locatech.locatech.repositories.PessoaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> findAllPessoa(int page, int size){
        int offset = (page - 1) * size;

        return pessoaRepository.findAll(size, offset);

    }

    public Optional<Pessoa> findPessoaById(Long id){
        return pessoaRepository.findById(id);
    }

    public void savePessoa(Pessoa pessoa){
        Integer save = pessoaRepository.save(pessoa);

        Assert.state(save == 1, "Erro ao salvar Pessoa " + pessoa.getNome());

    }

    public void updatePessoa(Pessoa pessoa, Long id){
        Integer update = pessoaRepository.update(pessoa, id);

        if(update == 0) throw new RuntimeException("Pessoa nao encontrado");

    }

    public void delete(Long id){
        Integer delete = pessoaRepository.delete(id);

        if(delete == 0) throw new RuntimeException("Pessoa nao encontrado");

    }

}