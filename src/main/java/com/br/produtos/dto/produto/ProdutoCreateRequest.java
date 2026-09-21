package com.br.produtos.dto.produto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.math.BigDecimal;

/**
 *  Dados para cadastrar um Produto
 *
 *  @param nome nome do produto
 *  @param preco seu preço de mercado
 * * */
@Schema(description = "Dados utilizados para cadastrar um Produto")

@Builder
public record ProdutoCreateRequest(

        @Schema (
                description = "Nome do Produto",
                example = "Iphone 15"
        )
        @NotBlank(message = "o nome é obrigatório")
        @Size(min = 3, max = 100, message = "o nome deve possuir entre 3 e 100 caracteres")
        String nome,

        @Schema (
                description = "Preço do Produto",
                example = "4500.0"
        )
        @NotNull(message = "o preço é obrigatório")
        @Positive(message = "o preço deve ser maior que 0")
        BigDecimal preco
) {
}
