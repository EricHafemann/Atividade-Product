package com.br.produtos.service;

import com.br.produtos.repository.JpaUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Implementação do {@link UserDetailsService} usada pelo Spring Security
 * para autenticar os usuários da aplicação.
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final JpaUserRepository repository;

    /**
     * Busca o usuário pelo CPF, que funciona como "username" para
     * fins de autenticação.
     *
     * @param cpf CPF informado nas credenciais da requisição
     * @return os dados do usuário (a própria {@code UserEntity}, que implementa {@link UserDetails})
     * @throws UsernameNotFoundException se não existir usuário com esse CPF
     */
    @Override
    public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
        return repository.findByCpf(cpf)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}