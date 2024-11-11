package com.mercadinho.services;

import com.mercadinho.domains.Funcionario;
import com.mercadinho.domains.dtos.FuncionarioDTO;
import com.mercadinho.repositories.FuncionarioRepository;
import com.mercadinho.services.exceptions.DataIntegrityViolationException;
import com.mercadinho.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public List<FuncionarioDTO> findAll() {
        return funcionarioRepository.findAll().stream().map(obj -> new FuncionarioDTO(obj)).collect(Collectors.toList());
    }

    public Funcionario findById(Long id) {
        Optional<Funcionario> obj = funcionarioRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado no sistema! ID: " + id));
    }

    public Funcionario findByCpf(String cpf) {
        Optional<Funcionario> obj = funcionarioRepository.findByCpf(cpf);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Funcionário não encontrado no sistema! CPF: " + cpf));
    }

    public Funcionario create(FuncionarioDTO objDto) {
        objDto.setId(null);
        validarPorCPF(objDto);
        Funcionario newObj = new Funcionario(objDto);
        return funcionarioRepository.save(newObj);
    }

    public Funcionario update(Long id, FuncionarioDTO objDto) {
        objDto.setId(id);
        Funcionario oldObj = findById(id);
        validarPorCPF(objDto);
        oldObj = new Funcionario(objDto);
        return funcionarioRepository.save(oldObj);
    }

    public void delete(Long id) {
        Funcionario obj = findById(id);
        funcionarioRepository.deleteById(id);
    }

    private void validarPorCPF(FuncionarioDTO objDto) {
        Optional<Funcionario> obj = funcionarioRepository.findByCpf(objDto.getCpf());

        if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
    }
}
