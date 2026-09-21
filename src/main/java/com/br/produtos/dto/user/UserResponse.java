package com.br.produtos.dto.user;

import com.br.produtos.entity.Enum.Role;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * DTO de resposta da entidade UserEntity
 *
 * @param id Identificador único do usuário
 * @param nome Nome completo do usuário
 * @param cpf CPF do usuário
 * @param role Perfil de acesso do usuário
 */
public record UserResponse(

        @Schema(description = "Identificador único do usuário", example = "1")
        Long id,

        @Schema(description = "Nome completo do usuário", example = "Maria Silva")
        String nome,

        @Schema(description = "CPF do usuário, apenas números (usado como login)", example = "22222222222")
        String cpf,

        @Schema(description = "Perfil de acesso do usuário", example = "USER")
        Role role
) {}