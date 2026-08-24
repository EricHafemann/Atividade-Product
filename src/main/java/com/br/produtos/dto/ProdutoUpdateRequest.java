package com.br.produtos.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;

/**
 *  Dados para atualizar um Produto
 *
 *  @param nome nome do produto
 *  @param preco seu preço de mercado
 *  @param ativo situação do produto
 * * */
@Builder
@Schema(description = "Dados utilizados para atualizar um Produto")
public record ProdutoUpdateRequest(


        @NotBlank(message = "o nome é obrigatório")
        @Size(min = 3, max = 100, message = "o nome deve possuir entre 3 e 100 caracteres")
        @Schema(example = "monitor 27 polegadas")
        String nome,


        @NotNull(message = "o preço é obrigatório")
        @Positive(message = "o preço deve ser maior que 0")
        @Schema(example = "1999.00")
        BigDecimal preco,

        @NotNull(message = "O campo ativo é obrigatório")
        @Schema(example = "true")
        Boolean ativo
) {
}
