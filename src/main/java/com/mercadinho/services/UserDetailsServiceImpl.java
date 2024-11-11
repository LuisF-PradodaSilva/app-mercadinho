package com.mercadinho.services;

import com.mercadinho.domains.Funcionario;
import com.mercadinho.repositories.FuncionarioRepository;
import com.mercadinho.security.UserSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final FuncionarioRepository funcionarioRepository;

    public UserDetailsServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Funcionario> funcionario = funcionarioRepository.findByCpf(username);

        if (funcionario.isEmpty()) {
            throw new UsernameNotFoundException("User not found! CPF: " + username);
        }
        return new UserSS(funcionario.orElse(null));
    }
}
