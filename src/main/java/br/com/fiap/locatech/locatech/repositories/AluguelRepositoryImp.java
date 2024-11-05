package br.com.fiap.locatech.locatech.repositories;

import br.com.fiap.locatech.locatech.entities.Aluguel;
import br.com.fiap.locatech.locatech.entities.Veiculo;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AluguelRepositoryImp implements AluguelRepository{

    private final JdbcClient jdbcClient;

    public AluguelRepositoryImp(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    @Override
    public Optional<Aluguel> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT a.id, a.pessoa_id, a.veiculo_id, a.data_inicio, a.data_fim, a.valor_total, " +
                        "p.nome as pessoa_nome, p.cpf as pessoa_cpf, " +
                        "v.modelo as veiculo_modeo, v.placa as veiculo_placa " +
                        "FROM alugueis a " +
                        "join pessoas p on a.pessoa_id = p.id " +
                        "join veiculos v on a.veiculo_id = v.id " +
                        "where a.id = :id")
                .param("id", id)
                .query(Aluguel.class)
                .optional();
    }

    @Override
    public List<Aluguel> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT a.id, a.pessoa_id, a.veiculo_id, a.data_inicio, a.data_fim, a.valor_total, " +
                        "p.nome as pessoa_nome, p.cpf as pessoa_cpf, " +
                        "v.modelo as veiculo_modeo, v.placa as veiculo_placa " +
                        "FROM alugueis a " +
                        "join pessoas p on a.pessoa_id = p.id " +
                        "join veiculos v on a.veiculo_id = v.id " +
                        "LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Aluguel.class)
                .list();
    }

    @Override
    public Integer save(Aluguel aluguel) {
        return this.jdbcClient
                .sql("INSERT INTO alugueis (pessoa_id, veiculo_id, data_inicio, data_fim, valor_total) " +
                        " VALUES (:pessoaId, :veiculoId, :dataInicio, :dataFim, :valorTotal)")
                .param("pessoaId", aluguel.getIdPessoa())
                .param("veiculoId", aluguel.getIdVeiculo())
                .param("dataInicio", aluguel.getDataInicio())
                .param("dataFim", aluguel.getDataFim())
                .param("valorTotal", aluguel.getValorTotal())
                .update();
    }

    @Override
    public Integer update(Aluguel aluguel, Long id) {
        return this.jdbcClient
                .sql("UPDATE alugueis SET pessoa_id = pessoaId, veiculo_id = :veiculoId, data_inicio = :dataInicio, data_fim = :dataFim, valor_total = :valorTotal WHERE id = :id)")
                .param("pessoaId", aluguel.getIdPessoa())
                .param("veiculoId", aluguel.getIdVeiculo())
                .param("dataInicio", aluguel.getDataInicio())
                .param("dataFim", aluguel.getDataFim())
                .param("valorTotal", aluguel.getValorTotal())
                .param("id", id)
                .update();
    }

    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM alugueis WHERE id = :id)")
                .param("id", id)
                .update();
    }
}
