package com.br.produtos.controller;

import com.br.produtos.dto.ErroResponse;
import com.br.produtos.dto.ProdutoCreateRequest;
import com.br.produtos.dto.ProdutoResponse;
import com.br.produtos.dto.ProdutoUpdateRequest;
import com.br.produtos.entity.ProdutoEntity;
import com.br.produtos.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Produto Controller.",
        description = "Operações e End Points relacionadas a classe Produto."
)
@RestController
@RequestMapping("/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    /**
     * Cadastra um novo produto.
     *
     * @param dto produto request com os dados necessários para criar.
     * @return dto {@link ProdutoResponse} com o produto cadastrado.
     */

    @Operation(
            summary = "Cadastra um novo produto",
            description = "Adiciona um novo produto ao catalogo."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Produto criado com sucesso."
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados da requisição inválidos",
                    content = @Content(schema = @Schema(implementation =
                    ErroResponse.class))
            )
    })

    @PostMapping
    public ResponseEntity<ProdutoResponse> create(@RequestBody ProdutoCreateRequest dto)
    {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoService.create(dto));
    }

    /**
     * Busca um produto pelo ID
     *
     * @param id identificador do produto
     * @return dto {@link ProdutoResponse} com o produto.
     */

    @Operation(
            summary = "Busca produto",
            description = "Busca um produto pelo seu ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Produto encontrado com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Produto não foi encontrado",
                    content = @Content(schema = @Schema(implementation =
                            ErroResponse.class))
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.findById(id));
    }

    /**
     * Busca todos os produto
     *
     * @return lista de {@link ProdutoResponse} com o produtos.
     */
    @Operation(
            summary = "Busca todos os produto",
            description = "Busca todos os produtos registrados no sistema"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Produtos encontrados com sucesso."
            )
    })
    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> findAll()
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.findAll());
    }

    /**
     * Busca produto pelo nome
     *
     * @param nome nome do produto
     * @return {@link ProdutoResponse} com o produto.
     */

    @Operation(
            summary = "Busca produto pelo nome",
            description = "Busca um produto pelo seu nome."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Produtos encontrado com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Produtos não foi encontrado."
            )
    })

    @GetMapping(params = "nome")
    public ResponseEntity<ProdutoResponse> findByNome(@RequestParam String nome)
    {
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.findByNome(nome));
    }

    /**
     * Altera um produto
     *
     * @param id identificador do produto
     * @param dto ProdutoUpdateRequest
     * @return ProdutoResponse com o usuário atualizado
     */

    @Operation(
            summary = "Altera um produto ",
            description = "Altera um produto pelo id."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Produtos atualizado com sucesso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Produtos não foi encontrado."
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos."
            )
    })

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> update (@PathVariable Long id,
                                                   @RequestBody ProdutoUpdateRequest dto)
    {
        return ResponseEntity.status(200).body(produtoService.update(id, dto));
    }

    /**
     * Remove produto pelo id
     *
     * @param id id do produto
     */

    @Operation(
            summary = "Deleta produto pelo ID",
            description = "Deleta um produto passando seu ID."
    )
    @ApiResponse(
            responseCode = "204",
            description = "Deleta um produto escolhido pelo id."
    )

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete (@PathVariable Long id)
    {
        produtoService.remover(id);
    }
}
