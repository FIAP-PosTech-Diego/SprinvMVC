package br.com.fiap.locatech.locatech.entities;

import br.com.fiap.locatech.locatech.dtos.AluguelDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Aluguel {

    private Long id;
    private Long idPessoa;
    private Long idVeiculo;
    private String veiculoModelo;
    private String pessoaCpf;
    private String pessoaNome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal valorTotal;

    public Aluguel(AluguelDTO dto, BigDecimal valorTotal) {
        this.idPessoa = dto.pessoaId();
        this.idVeiculo = dto.veiculoId();
        this.dataInicio = dto.dataInicio();
        this.dataFim = dto.dataFim();
        this.valorTotal = valorTotal;
    }
}
