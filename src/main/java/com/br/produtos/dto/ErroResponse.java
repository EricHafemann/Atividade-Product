package com.br.produtos.dto;

import lombok.Builder;

import java.time.LocalDateTime;

/**
 * DTO responsável pelos erros na aplicação.
 *
 * @param path caminho do erro
 * @param mensagem mensagem de erro
 * @param data data e hora do erro
 * @param status código de status do erro
 */
@Builder
public record ErroResponse(

         String path,
         String mensagem,
         LocalDateTime data,
         Integer status

) {
}
