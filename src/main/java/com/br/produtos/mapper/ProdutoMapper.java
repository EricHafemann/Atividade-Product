package com.br.produtos.mapper;

import com.br.produtos.dto.produto.ProdutoCreateRequest;
import com.br.produtos.dto.produto.ProdutoResponse;
import com.br.produtos.dto.produto.ProdutoUpdateRequest;
import com.br.produtos.entity.ProdutoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoMapper {

    /**
     * Converte os dados de criação para uma entidade Produto.
     * @param produtoCreateRequest
     * @return ProdutoEntity
     */
    public ProdutoEntity toEntity (ProdutoCreateRequest produtoCreateRequest)
    {
        return ProdutoEntity.builder()
                .nome(produtoCreateRequest.nome())
                .preco(produtoCreateRequest.preco())
                .ativo(true)
                .build();
    }

    /**
     * Converte uma entidade Produto em uma Response.
     * @param produtoEntity
     * @return ProdutoResponse
     */
    public ProdutoResponse toResponse (ProdutoEntity produtoEntity)
    {
        return ProdutoResponse.builder()
                .id(produtoEntity.getId())
                .nome(produtoEntity.getNome())
                .preco(produtoEntity.getPreco())
                .ativo(produtoEntity.getAtivo())
                .build();
    }

    /**
     * Converte uma lista entidade Produto em uma lista de Response.
     * @param listProdutoEntity
     * @return List<ProdutoResponse>
     */
    public List<ProdutoResponse> toResponseList (List<ProdutoEntity> listProdutoEntity)
    {
        return listProdutoEntity.stream()
                .map(this::toResponse)
                .toList();
    }

    /**
     * Atualiza um ProdutoEntity ja existente.
     * @param request e produto
     */
    public void updateEntity (ProdutoUpdateRequest request, ProdutoEntity produto)
    {
        produto.setNome(request.nome());
        produto.setPreco(request.preco());
        produto.setAtivo(request.ativo());
    }
}
