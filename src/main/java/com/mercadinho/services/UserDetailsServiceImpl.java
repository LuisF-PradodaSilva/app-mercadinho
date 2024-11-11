package com.mercadinho.services;

import com.mercadinho.domains.Pessoa;
import com.mercadinho.repositories.PessoaRepository;
import com.mercadinho.security.UserSS;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final PessoaRepository pessoaRepository;

    public UserDetailsServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Pessoa> pessoa = pessoaRepository.findByCpf(username);

        if (pessoa.isEmpty()) {
            throw new UsernameNotFoundException("User not found! CPF: " + username);
        }
        return new UserSS(pessoa.orElse(null));
    }
}
