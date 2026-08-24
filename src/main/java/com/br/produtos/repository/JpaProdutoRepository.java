package com.br.produtos.repository;

import com.br.produtos.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório reponsãvel pela classe ProdutoEntity
 */
public interface JpaProdutoRepository extends JpaRepository<ProdutoEntity, Long> {

    /**
     * Verifica se existe produto com o nome informado
     * Ignora diferença entre letras maiúsculas e minúsculas
     * @param nome nome a ser pesquisado
     * @return {@code true} caso o produto exista com o nome
     * */
    boolean existsByNomeIgnoreCase(String nome);

    /**
     * Busca produtos cujo nome contenha o texto informado
     * @param nome parte do nome do produto
     * @return produtos encontrados
     * */
    ProdutoEntity findByNomeContainingIgnoreCase (String nome);
}
