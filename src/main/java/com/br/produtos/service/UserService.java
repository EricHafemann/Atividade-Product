package com.br.produtos.service;


import com.br.produtos.dto.user.RegisterRequest;
import com.br.produtos.dto.user.UserResponse;
import com.br.produtos.entity.Enum.Role;
import com.br.produtos.entity.UserEntity;
import com.br.produtos.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 * Serviço responsável pelas regras de negócio de UserEntity.
 * */
@Service
@RequiredArgsConstructor
public class UserService {

    private final JpaUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    /**
     * Método de registrar um novo usuário.
     *
     * @param request RegisterRequest
     * @return UserResponse
     */
    @Transactional
    public UserResponse register(RegisterRequest request) {
        if (repository.existsByCpf(request.cpf())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "CPF já cadastrado");
        }

        UserEntity user = UserEntity.builder()
                .nome(request.nome())
                .cpf(request.cpf())
                .senha(passwordEncoder.encode(request.senha()))
                .role(Role.USER)
                .build();

        UserEntity saved = repository.save(user);
        return new UserResponse(saved.getId(), saved.getNome(), saved.getCpf(), saved.getRole());
    }
}