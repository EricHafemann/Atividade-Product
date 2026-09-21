package com.br.produtos.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * DTO de registro da entidade UserEntity
 *
 * @param nome Nome do usuário
 * @param cpf CPF do usuário
 * @param senha Senha do Usuário
 */
public record RegisterRequest(

        @Schema(description = "Nome do usuário", example = "Adriel Cavalheiro")
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @Schema(description = "CPF do usuário", example = "12345681234")
        @NotBlank(message = "CPF é obrigatório")
        @Size(max = 11,min = 11, message = "O CPF deve conter 11 caracteres")
        String cpf,

        @Schema(description = "Senha do Usuário", example = "123@Mudar")
        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
        String senha
) {}