package com.br.produtos.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErroResponse(

        String menssagem,
        LocalDateTime data,
        String path,
        Integer status
) {
}
