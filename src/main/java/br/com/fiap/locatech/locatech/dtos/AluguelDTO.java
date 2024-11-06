package br.com.fiap.locatech.locatech.dtos;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelDTO(
        @NotNull(message = "Id da pessoa nao pode ser null")
        Long pessoaId,
        @NotNull(message = "Id do veiculo nao pode ser null")
        Long veiculoId,
        LocalDate dataInicio,
        LocalDate dataFim) {
}
