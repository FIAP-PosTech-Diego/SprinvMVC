package br.com.fiap.locatech.locatech.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record AluguelDTO(
        @Schema(description = "id da pessoa que esta alugando o veiculo")
        @NotNull(message = "Id da pessoa nao pode ser null")
        Long pessoaId,
        @NotNull(message = "Id do veiculo nao pode ser null")
        Long veiculoId,
        LocalDate dataInicio,
        LocalDate dataFim) {
}
