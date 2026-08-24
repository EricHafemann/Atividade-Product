package com.br.produtos.config;

import com.br.produtos.entity.ProdutoEntity;
import com.br.produtos.repository.JpaProdutoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class ProdutosIniciais {

    @Bean
    CommandLineRunner initDatabase(JpaProdutoRepository produtoRepository)
    {
        return args -> {

            produtoRepository.save(new ProdutoEntity(
                    null,
                    "Iphone XV",
                    new BigDecimal(4500),
                    true)
            );

            produtoRepository.save(new ProdutoEntity(
                    null,
                    "Monitor AOC 24 polegadas",
                    new BigDecimal(1200),
                    true)
            );

            produtoRepository.save(new ProdutoEntity(
                    null,
                    "Mouse Multilaser",
                    new BigDecimal(35),
                    true)
            );
        };
    }
}
