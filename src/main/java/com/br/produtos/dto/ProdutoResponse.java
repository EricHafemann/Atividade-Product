package com.br.produtos.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.math.BigDecimal;

/**
 * Resposta que o usuário irá receber da Api
 *
 * @param id id do produto
 * @param nome nome oo produto
 * @param preco preco do produto
 * @param ativo situação atual do produto
 */
@Builder
public record ProdutoResponse(

        @Schema(description = "Identificador do Produto", example = "1")
        Long id,

        @Schema(description = "Nome do Produto", example = "Iphone 15")
        String nome,

        @Schema(description = "Preço do Produto", example = "4500.0")
        BigDecimal preco,

        @Schema(description = "Indica situação do Produto", example = "true")
        Boolean ativo
){}
