package com.br.produtos.service;

import com.br.produtos.dto.produto.ProdutoCreateRequest;
import com.br.produtos.dto.produto.ProdutoResponse;
import com.br.produtos.dto.produto.ProdutoUpdateRequest;
import com.br.produtos.entity.ProdutoEntity;
import com.br.produtos.exception.ProdutoNaoEncontradoException;
import com.br.produtos.mapper.ProdutoMapper;
import com.br.produtos.repository.JpaProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Serviço responsável pelas regras de negócio  * relacionadas ao gerenciamento de produtos
 * */

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final JpaProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;


    /**
     * Cadastra um novo produto na base de dados após validar a unicidade do nome
     * @param dto Objeto contendo os dados de entrada para criação do produto
     * @return DTO {@link ProdutoResponse} com os dados do produto persistido
     * @throws IllegalArgumentException Se já existir um produto cadastrado com o mesmo nome
     * */
    public ProdutoResponse create(ProdutoCreateRequest dto) {

        if(produtoRepository.existsByNomeIgnoreCase(dto.nome()))
        {
            throw new IllegalArgumentException("Produto com esse nome já existente.");
        }

        ProdutoEntity produto = produtoRepository.save(produtoMapper.toEntity(dto));

        return produtoMapper.toResponse(produto);
    }

    /**
     * Busca um produto pelo seu identificador único
     * @param id Identificador do produto a ser localizaoo
     * @return DTO {@link ProdutoResponse} representando o produto encontrado
     * @throws ProdutoNaoEncontradoException Se nenhum produto for encontrado com o ID informado
     * */
    @Transactional(readOnly = true)
    public ProdutoResponse findById (Long id)
    {

        Optional<ProdutoEntity> produto = produtoRepository.findById(id);

        if(produto.isEmpty())
        {
            throw new ProdutoNaoEncontradoException("Produto não foi encontrado com esse Id.");
        }

        return produtoMapper.toResponse(produto.get());

    }

    /**
     * Retorna todos os produtos cadastrados
     * @return Lista de DTOs {@link ProdutoResponse} representando os produtos encontrados.Lista vazia caso nenhum produto seja encontrado
     */
    @Transactional(readOnly = true)
    public List<ProdutoResponse> findAll ()
    {

        List<ProdutoEntity> produtos = produtoRepository.findAll();

        return produtoMapper.toResponseList(produtos);

    }

    /**
     * Busca produtos cujo nome contenha o termo informado (case insensitive)
     * @param nome Termo ou trecho do nome do produto a ser pesquisado
     * @return Lista de DTOs {@link ProdutoResponse} correspondentes ao termo informado
     * */
    @Transactional(readOnly = true)
    public ProdutoResponse findByNome(String nome) {

        if(!produtoRepository.existsByNomeIgnoreCase(nome))
        {
            throw new ProdutoNaoEncontradoException("Produto não foi encontrado com esse nome.");
        }

        ProdutoEntity produtoEntity = produtoRepository.findByNomeContainingIgnoreCase(nome);

        return produtoMapper.toResponse(produtoEntity);
    }

    /**
     * Atualiza todos os dados de um produto existente
     *
     * @param id Identificador do produto a ser atualizado
     * @param dto DTO co os novos dados do produto
     * @return DTO {@link ProdutoResponse} com os dados do produto atualizados
     * @throws ProdutoNaoEncontradoException Se nenhum produto for encontrado para o ID informado
     */

    public ProdutoResponse update(Long id, ProdutoUpdateRequest dto) {

        Optional<ProdutoEntity> produto = produtoRepository.findById(id);

        if(produto.isEmpty())
        {
            throw new ProdutoNaoEncontradoException("Produto não foi encontrado com esse Id.");
        }

        ProdutoEntity produtoEntity = produto.get();

        produtoMapper.updateEntity(dto, produtoEntity);

        produtoRepository.save(produtoEntity);

        return produtoMapper.toResponse(produtoEntity);
    }

    /**
     * Remove um produto da bas de dados pelo seu identificador
     * @param id Identificador do produto a ser removido
     * @throws ProdutoNaoEncontradoException Se nennhum produto for encontrado com o ID informado
     * */

    @Transactional
    public void remover (Long id)
    {
        Optional<ProdutoEntity> produto = produtoRepository.findById(id);

        if(produto.isEmpty())
        {
            throw new ProdutoNaoEncontradoException("Produto não foi encontrado com esse Id.");
        }

        produtoRepository.delete(produto.get());
    }
}
